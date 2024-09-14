package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class LicenseService {
    private final MessageSource messageSource;

    public License getLicense(String licenseId, String organizationId) {
        return License.builder()
                .id(new Random().nextInt(1000))
                .licenseId(licenseId)
                .organizationId(organizationId)
                .description("test description")
                .productName("test product name")
                .licenseType("test license type")
                .build();
    }

    public String createLicense(License license, String organizationId, Locale locale){
        String responseMessage = null;
        if(license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messageSource.getMessage("license.create.message", null, locale), license.toString());
        }
        return responseMessage;
    }

    public String updateLicense(License license, String organizationId){
        String responseMessage = null;
        if (license != null) {
            license.setOrganizationId(organizationId);
            responseMessage = String.format(messageSource.getMessage("license.create.message", null, null), license.toString());
        }
        return responseMessage;
    }

    public String deleteLicense(String licenseId, String organizationId){
        String responseMessage = null;
        responseMessage = String.format(messageSource.getMessage("license.create.message", null, null),licenseId, organizationId);
        return responseMessage;
    }
}
