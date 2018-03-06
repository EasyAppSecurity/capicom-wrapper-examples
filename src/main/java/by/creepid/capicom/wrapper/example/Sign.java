package by.creepid.capicom.wrapper.example;

import by.creepid.capicom.wrapper.*;

import java.util.Date;

public class Sign {

    public static void main(String[] args) throws Exception {
        //2  - storeLocation
        //"My" - storeName
        //2 - openMode
        CapicomStore store = new CapicomStore(2, "My", 2);
        //1 - certificate number in windows store
        CapicomCertificate cert = store.getCertificates().getAll()[0];
        CapicomSigner signer = new CapicomSigner();
        signer.setCertificate(cert);

        CapicomSignedData signedData = new CapicomSignedData();
        //"test" - signing string
        signedData.setContent("test");

        CapicomAttribute signingTime = new CapicomAttribute();
        //Add signing time attribute, see CapicomAttributeEnum
        signingTime.setName(CapicomAttributeEnum.CAPICOM_AUTHENTICATED_ATTRIBUTE_SIGNING_TIME);
        signingTime.setValue(new Date());

        signer.getAuthenticatedAttributes().add(signingTime);
        //return signature, throws InvalidCertificate otherwice
        String signature = signedData.sign(signer, true);
        System.out.println(signature);
    }

}
