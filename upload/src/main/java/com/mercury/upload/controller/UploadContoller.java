package com.mercury.upload.controller;

import com.mercury.upload.Storage.FileNoteFoundException;
import com.mercury.upload.Storage.StorageException;
import com.mercury.upload.Storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.stream.Collectors;


@Controller
@RequestMapping(value = "demo")
public class UploadContoller {
    @Autowired
    private final StorageService storageService;

    public UploadContoller(StorageService storageService) {
        this.storageService=storageService;
    }

    @GetMapping("/")
    public String listUploeadedFiles(Model model){
        model.addAttribute("files",storageService.loadAll()
                .map(path -> MvcUriComponentsBuilder
                        .fromMethodName(UploadContoller.class,"serverFile",path.getFileName().toString())
                .build().toString())
        .collect(Collectors.toList()));

          return "uploadForm" ;
    }
    @GetMapping("files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serverFile(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);
        return  ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+file.getFilename()+"\"")
                .body(file);
    }
    @PostMapping("/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes){
        storageService.store(file);
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        return  "redirect:/demo/";
    }

    @ExceptionHandler(StorageException.class)
    public ResponseEntity handleStorageFileNotFound(StorageException exception){
        return  ResponseEntity.notFound().build();
    }
}
