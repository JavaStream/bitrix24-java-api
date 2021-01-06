package com.javastream.utils.lead;

import com.javastream.entity.Lead;

import java.util.HashMap;


public class MultiFieldsForLeadCreator {

    private HashMap<String, String> map = new HashMap<>();

    public HashMap<String, String> getPhotoFields(Lead lead) {
        int size = lead.getPHONE().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String phoneId = lead.getPHONE().get(i).getID();
                String phoneTypeId = lead.getPHONE().get(i).getTYPE_ID();

                if (phoneId != null) {
                    map.put("FIELDS[PHONE][" + i + "][ID]", phoneId);
                }

                if (phoneTypeId != null) {
                    map.put("FIELDS[PHONE][" + i + "][TYPE_ID]", phoneTypeId);
                }

                map.put("FIELDS[PHONE][" + i + "][VALUE]", lead.getPHONE().get(i).getVALUE());
                map.put("FIELDS[PHONE][" + i + "][VALUE_TYPE]", lead.getPHONE().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getEmailFields(Lead lead) {
        int size = lead.getEMAIL().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String emailId = lead.getEMAIL().get(i).getID();
                String emailTypeId = lead.getEMAIL().get(i).getTYPE_ID();

                if (emailId != null) {
                    map.put("FIELDS[EMAIL][" + i + "][ID]", emailId);
                }

                if (emailTypeId != null) {
                    map.put("FIELDS[EMAIL][" + i + "][TYPE_ID]", emailTypeId);
                }

                map.put("FIELDS[EMAIL][" + i + "][VALUE]", lead.getEMAIL().get(i).getVALUE());
                map.put("FIELDS[EMAIL][" + i + "][VALUE_TYPE]", lead.getEMAIL().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getWebsiteFields(Lead lead) {
        int size = lead.getWEB().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String webId = lead.getWEB().get(i).getID();
                String webTypeId = lead.getWEB().get(i).getTYPE_ID();

                if (webId != null) {
                    map.put("FIELDS[WEB][" + i + "][ID]", webId);
                }

                if (webTypeId != null) {
                    map.put("FIELDS[WEB][" + i + "][TYPE_ID]", webTypeId);
                }

                map.put("FIELDS[WEB][" + i + "][VALUE]", lead.getWEB().get(i).getVALUE());
                map.put("FIELDS[WEB][" + i + "][VALUE_TYPE]", lead.getWEB().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getMessengerFields(Lead lead) {
        int size = lead.getIM().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String imId = lead.getIM().get(i).getID();
                String imTypeId = lead.getIM().get(i).getTYPE_ID();

                if (imId != null) {
                    map.put("FIELDS[IM][" + i + "][ID]", imId);
                }

                if (imTypeId != null) {
                    map.put("FIELDS[IM][" + i + "][TYPE_ID]", imTypeId);
                }

                map.put("FIELDS[IM][" + i + "][VALUE]", lead.getIM().get(i).getVALUE());
                map.put("FIELDS[IM][" + i + "][VALUE_TYPE]", lead.getIM().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }
}
