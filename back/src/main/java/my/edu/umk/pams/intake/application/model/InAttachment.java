package my.edu.umk.pams.intake.application.model;

import com.google.common.primitives.Bytes;

import my.edu.umk.pams.intake.core.InMetaObject;

/**
 * IC, Birth Certificate, SPM, Other Qualification
*/
public interface InAttachment extends InMetaObject {

    String getName();

    void setName(String name);

    String getUrl();

    void setUrl(String url);

    InIntakeApplication getApplication();

    void setApplication(InIntakeApplication application);
    
    byte[] getBytes();

    void setBytes(byte[] bytes);

	String getMimeType();

	void setMimeType(String mimeType);

	int getSize();

	void setSize(int size);
}
