package com.javastream.utils.company;

import com.javastream.entity.Company;

import java.util.HashMap;


public class MultiFieldsForCompanyCreator {

    private HashMap<String, String> map = new HashMap<>();

    public HashMap<String, String> getPhotoFields(Company company) {
        int size = company.getPHONE().size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String phoneId = company.getPHONE().get(i).getID();
                String phoneTypeId = company.getPHONE().get(i).getTYPE_ID();

                if (phoneId != null) {
                    map.put("FIELDS[PHONE][" + i + "][ID]", phoneId);
                }

                if (phoneTypeId != null) {
                    map.put("FIELDS[PHONE][" + i + "][TYPE_ID]", phoneTypeId);
                }

                map.put("FIELDS[PHONE][" + i + "][VALUE]", company.getPHONE().get(i).getVALUE());
                map.put("FIELDS[PHONE][" + i + "][VALUE_TYPE]", company.getPHONE().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getEmailFields(Company company) {
        int size = company.getEMAIL().size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String emailId = company.getEMAIL().get(i).getID();
                String emailTypeId = company.getEMAIL().get(i).getTYPE_ID();

                if (emailId != null) {
                    map.put("FIELDS[EMAIL][" + i + "][ID]", emailId);
                }
                if (emailTypeId != null) {
                    map.put("FIELDS[EMAIL][" + i + "][TYPE_ID]", emailTypeId);
                }

                map.put("FIELDS[EMAIL][" + i + "][VALUE]", company.getEMAIL().get(i).getVALUE());
                map.put("FIELDS[EMAIL][" + i + "][VALUE_TYPE]", company.getEMAIL().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getWebsiteFields(Company company) {
        int size = company.getWEB().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String webId = company.getWEB().get(i).getID();
                String webTypeId = company.getWEB().get(i).getTYPE_ID();

                if (webId != null) {
                    map.put("FIELDS[WEB][" + i + "][ID]", webId);
                }
                if (webTypeId != null) {
                    map.put("FIELDS[WEB][" + i + "][TYPE_ID]", webTypeId);
                }

                map.put("FIELDS[WEB][" + i + "][VALUE]", company.getWEB().get(i).getVALUE());
                map.put("FIELDS[WEB][" + i + "][VALUE_TYPE]", company.getWEB().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getMessengerFields(Company company) {
        int size = company.getIM().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String imId = company.getIM().get(i).getID();
                String imTypeId = company.getIM().get(i).getTYPE_ID();

                if (imId != null) {
                    map.put("FIELDS[IM][" + i + "][ID]", imId);
                }

                if (imTypeId != null) {
                    map.put("FIELDS[IM][" + i + "][TYPE_ID]", imTypeId);
                }

                map.put("FIELDS[IM][" + i + "][VALUE]", company.getIM().get(i).getVALUE());
                map.put("FIELDS[IM][" + i + "][VALUE_TYPE]", company.getIM().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }
}