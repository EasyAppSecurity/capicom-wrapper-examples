package by.creepid.capicom.wrapper.example;

import by.creepid.capicom.wrapper.*;
import by.creepid.capicom.wrapper.exception.InvalidSignature;

import java.util.Date;

public class Verify {

    public static void main(String[] args) {
        //signature in base64
        String signature = SignatureSamples.AV_SIGNATURE;
        boolean isDetached = true;

        CapicomSignedData signedData = new CapicomSignedData();
        signedData.setContent("test");

        try {
            signedData.verify(signature, isDetached);
            System.out.println("Signature is valid");
        } catch (InvalidSignature ex) {
            System.out.println("Signature is invalid: " + ex.getMessage());
        }

        //get certificate information
        CapicomCertificate cert = signedData.getCertificates().getAll()[0];
        //cert.display();

        //get subject
        String subject = signedData.getCertificates().getAll()[0].getSubjectName();
        System.out.println("Signature subject:" + subject);

        CapicomSigner signer = signedData.getSigners()[0];
        CapicomAttribute attr = signer.getAuthenticatedAttributes().getAll()[0];

        //signing date...
        Date date = attr.getValue().getDateContent();
        System.out.println("Signing date: " + date.toString());
    }

}
