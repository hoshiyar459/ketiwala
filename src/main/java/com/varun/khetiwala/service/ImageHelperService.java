package com.varun.khetiwala.service;


import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

@Service
public class ImageHelperService {


    @Value("${file.upload-dir}")
    private String uploadDir;

    @PostConstruct
    public void initUploadDir() {
        Path path = Paths.get(uploadDir);
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
                System.out.println("✅ Upload directory created: " + path.toAbsolutePath());
            } catch (IOException e) {
                System.err.println("❌ Failed to create upload directory: " + e.getMessage());
            }
        } else {
            System.out.println("📁 Upload directory already exists: " + path.toAbsolutePath());
        }
    }

    private String saveImageToLocal(MultipartFile image) throws IOException {
        String originalFilename = image.getOriginalFilename();
        String extension = originalFilename != null && originalFilename.contains(".")
                ? originalFilename.substring(originalFilename.lastIndexOf("."))
                : "";

        String uniqueFileName = UUID.randomUUID().toString() + extension;
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(uniqueFileName);
        Files.copy(image.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }


    private void deleteImageFromFileSystem(String imageUrl) {
        if (imageUrl == null || imageUrl.isEmpty())
            return;

        String relativePath = imageUrl.replaceFirst("^/", ""); // remove starting slash
        Path imagePath = Paths.get(relativePath);

        try {
            Files.deleteIfExists(imagePath);
            System.out.println("🗑️ Image deleted: " + imagePath.toAbsolutePath());
        } catch (NoSuchFileException e) {
            System.err.println("⚠️ Image file not found: " + imagePath.toAbsolutePath());
        } catch (IOException e) {
            System.err.println("❌ Failed to delete image: " + e.getMessage());
        }
    }

}
