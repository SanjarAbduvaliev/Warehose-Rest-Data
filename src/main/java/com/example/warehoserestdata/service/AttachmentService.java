package com.example.warehoserestdata.service;
import com.example.warehoserestdata.entity.Attachment;
import com.example.warehoserestdata.entity.AttachmentContent;
import com.example.warehoserestdata.payload.Result;
import com.example.warehoserestdata.repository.AttachmentContentRepository;
import com.example.warehoserestdata.repository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {
    @Autowired
    AttachmentRepository attachmentRepository;
    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    public Result uploadFile(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment=new Attachment();
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);

        AttachmentContent attachmentContent=new AttachmentContent();
        attachmentContent.setAttachment(attachment);
        attachmentContent.setBytes(file.getBytes());
        attachmentContentRepository.save(attachmentContent);
        return new Result("Fayl muvofaqqiyatli saqlandi",true,savedAttachment.getId());

    }
    public List<Attachment> getAll(){
        return attachmentRepository.findAll();
    }
    public Attachment getId(Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        return optionalAttachment.orElseGet(Attachment::new);
    }
    public Result editPhoto(MultipartHttpServletRequest request,Integer id) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (!optionalAttachment.isPresent()){
            return new Result("Rasm mavjud emas",false);
        }
        Attachment attachment = optionalAttachment.get();
        if (file == null) {
            return new Result("Rasm mavud emas",false);
        }
        attachment.setName(file.getOriginalFilename());
        Attachment savedAttachment = attachmentRepository.save(attachment);


        Optional<AttachmentContent> optionalAttachmentContent = attachmentContentRepository.findById(id);
        AttachmentContent attachmentContent = optionalAttachmentContent.get();
        attachmentContent.setAttachment(savedAttachment);
        attachmentContent.setBytes(file.getBytes());

        attachmentContentRepository.save(attachmentContent);
        return new Result("Rasm o'zgartirildi",true);

    }
    public Result deletePhoto(Integer id){
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()){
            attachmentRepository.deleteById(id);
            attachmentContentRepository.deleteById(id);
            return new Result("Rasm o'chirildi",true);
        }

       return new Result("Rasm o'chirilmadi",false);



    }
}
