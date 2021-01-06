package com.javastream.utils.contact;

import com.javastream.entity.Contact;

import java.util.HashMap;


public class MultiFieldsForContactCreator {

    private HashMap<String, String> map = new HashMap<>();

    public HashMap<String, String> getPhotoFields(Contact contact) {
        int size = contact.getPHONE().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String phoneId = contact.getPHONE().get(i).getID();
                String phoneTypeId = contact.getPHONE().get(i).getTYPE_ID();

                if (phoneId != null) {
                    map.put("FIELDS[PHONE][" + i + "][ID]", phoneId);
                }
                if (phoneTypeId != null) {
                    map.put("FIELDS[PHONE][" + i + "][TYPE_ID]", phoneTypeId);
                }

                map.put("FIELDS[PHONE][" + i + "][VALUE]", contact.getPHONE().get(i).getVALUE());
                map.put("FIELDS[PHONE][" + i + "][VALUE_TYPE]", contact.getPHONE().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getEmailFields(Contact contact) {
        int size = contact.getEMAIL().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String emailId = contact.getEMAIL().get(i).getID();
                String emailTypeId = contact.getEMAIL().get(i).getTYPE_ID();

                if (emailId != null) {
                    map.put("FIELDS[EMAIL][" + i + "][ID]", emailId);
                }

                if (emailTypeId != null) {
                    map.put("FIELDS[EMAIL][" + i + "][TYPE_ID]", emailTypeId);
                }

                map.put("FIELDS[EMAIL][" + i + "][VALUE]", contact.getEMAIL().get(i).getVALUE());
                map.put("FIELDS[EMAIL][" + i + "][VALUE_TYPE]", contact.getEMAIL().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getWebsiteFields(Contact contact) {
        int size = contact.getWEB().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String webId = contact.getWEB().get(i).getID();
                String webTypeId = contact.getWEB().get(i).getTYPE_ID();

                if (webId != null) {
                    map.put("FIELDS[WEB][" + i + "][ID]", webId);
                }

                if (webTypeId != null) {
                    map.put("FIELDS[WEB][" + i + "][TYPE_ID]", webTypeId);
                }

                map.put("FIELDS[WEB][" + i + "][VALUE]", contact.getWEB().get(i).getVALUE());
                map.put("FIELDS[WEB][" + i + "][VALUE_TYPE]", contact.getWEB().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }

    public HashMap<String, String> getMessengerFields(Contact contact) {
        int size = contact.getIM().size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String imId = contact.getIM().get(i).getID();
                String imTypeId = contact.getIM().get(i).getTYPE_ID();

                if (imId != null) {
                    map.put("FIELDS[IM][" + i + "][ID]", imId);
                }

                if (imTypeId != null) {
                    map.put("FIELDS[IM][" + i + "][TYPE_ID]", imTypeId);
                }

                map.put("FIELDS[IM][" + i + "][VALUE]", contact.getIM().get(i).getVALUE());
                map.put("FIELDS[IM][" + i + "][VALUE_TYPE]", contact.getIM().get(i).getVALUE_TYPE());
            }
        }
        return map;
    }
}
