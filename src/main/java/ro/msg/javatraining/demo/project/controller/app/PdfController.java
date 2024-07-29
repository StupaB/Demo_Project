package ro.msg.javatraining.demo.project.controller.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ro.msg.javatraining.demo.project.service.AirportService;
import ro.msg.javatraining.demo.project.service.PdfService;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/pdf")
public class PdfController {
    @Autowired
    PdfService pdfService;
    @Autowired
    AirportService airportService;

    @GetMapping("/get")
    @Secured(value = { "ROLE_ADMIN"})
    public String getAirports() {

        return airportService.getAirports();
    }

    @GetMapping("/get/{id}")
    @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
    public String getAirportById(@PathVariable String id) {

        return airportService.getAirportById(id);
    }



    @GetMapping("/generate")
    @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<byte[]> generatePdf() {
        String text=airportService.getAirports();
        ByteArrayOutputStream baos = pdfService.generatePdf(text);
        byte[] pdfBytes = baos.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/generate/{id}")
    @Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
    public ResponseEntity<byte[]> generatePdf(@PathVariable String id) {
        String text=airportService.getAirportById(id);
        ByteArrayOutputStream baos = pdfService.generatePdf(text);
        byte[] pdfBytes = baos.toByteArray();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=generated.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }


}
