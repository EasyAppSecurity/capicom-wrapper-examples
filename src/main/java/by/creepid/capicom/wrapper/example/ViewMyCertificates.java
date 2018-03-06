package by.creepid.capicom.wrapper.example;

import by.creepid.capicom.wrapper.CapicomCertificate;
import by.creepid.capicom.wrapper.CapicomStore;

public class ViewMyCertificates {

    public static void main(String[] args) {
        //2  - storeLocation
        //"My" - storeName
        //2 - openMode
        CapicomStore store = new CapicomStore(2, "My", 2);
        CapicomCertificate[] certs = store.getCertificates().getAll();

        for (CapicomCertificate capicomCertificate : certs) {
            System.out.println(capicomCertificate.getSubjectName());
        }
    }
}
