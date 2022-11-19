package com.example.warehoserestdata.repository;

import com.example.warehoserestdata.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
