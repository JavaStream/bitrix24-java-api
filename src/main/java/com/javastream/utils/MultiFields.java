package com.javastream.utils;

import com.javastream.entity.model.Email;
import com.javastream.entity.model.Messenger;
import com.javastream.entity.model.Phone;
import com.javastream.entity.model.Website;

import java.util.HashMap;
import java.util.List;

/**
 * MultiFields.
 *
 * @author javastream
 */
public class MultiFields {

    private HashMap<String, String> map = new HashMap<>();

    public HashMap<String, String> getPhoneFields(List<Phone> phones) {
        int size = phones.size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String phoneId = phones.get(i).getId();
                String phoneTypeId = phones.get(i).getTypeId();

                if (phoneId != null) {
                    map.put("FIELDS[PHONE][" + i + "][ID]", phoneId);
                }

                if (phoneTypeId != null) {
                    map.put("FIELDS[PHONE][" + i + "][TYPE_ID]", phoneTypeId);
                }

                map.put("FIELDS[PHONE][" + i + "][VALUE]", phones.get(i).getValue());
                map.put("FIELDS[PHONE][" + i + "][VALUE_TYPE]", phones.get(i).getValueType());
            }
        }
        return map;
    }

    public HashMap<String, String> getEmailFields(List<Email> emails) {
        int size = emails.size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String emailId = emails.get(i).getId();
                String emailTypeId = emails.get(i).getTypeId();

                if (emailId != null) {
                    map.put("FIELDS[EMAIL][" + i + "][ID]", emailId);
                }

                if (emailTypeId != null) {
                    map.put("FIELDS[EMAIL][" + i + "][TYPE_ID]", emailTypeId);
                }

                map.put("FIELDS[EMAIL][" + i + "][VALUE]", emails.get(i).getValue());
                map.put("FIELDS[EMAIL][" + i + "][VALUE_TYPE]", emails.get(i).getValueType());
            }
        }
        return map;
    }

    public HashMap<String, String> getWebsiteFields(List<Website> websites) {
        int size = websites.size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String webId = websites.get(i).getId();
                String webTypeId = websites.get(i).getTypeId();

                if (webId != null) {
                    map.put("FIELDS[WEB][" + i + "][ID]", webId);
                }

                if (webTypeId != null) {
                    map.put("FIELDS[WEB][" + i + "][TYPE_ID]", webTypeId);
                }

                map.put("FIELDS[WEB][" + i + "][VALUE]", websites.get(i).getValue());
                map.put("FIELDS[WEB][" + i + "][VALUE_TYPE]", websites.get(i).getValueType());
            }
        }
        return map;
    }

    public HashMap<String, String> getMessengerFields(List<Messenger> messengers) {
        int size = messengers.size();

        if (size > 0) {
            for (int i = 0; i < size; i++) {
                String imId = messengers.get(i).getId();
                String imTypeId = messengers.get(i).getTypeId();

                if (imId != null) {
                    map.put("FIELDS[IM][" + i + "][ID]", imId);
                }

                if (imTypeId != null) {
                    map.put("FIELDS[IM][" + i + "][TYPE_ID]", imTypeId);
                }

                map.put("FIELDS[IM][" + i + "][VALUE]", messengers.get(i).getValue());
                map.put("FIELDS[IM][" + i + "][VALUE_TYPE]", messengers.get(i).getValueType());
            }
        }
        return map;
    }
}
