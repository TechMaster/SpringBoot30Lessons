package vn.techmaster.demoupload.localization;
import java.util.HashMap;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import vn.techmaster.demoupload.entity.LocalizeString;

public class DBMessageSource implements MessageSource {
  private HashMap<String, LocalizeString> localizeDB;
  public DBMessageSource() {
    localizeDB = new HashMap<>();
    localizeDB.put("demo_upload", new LocalizeString("Demo Upload File", "Ví dụ tải file"));
    localizeDB.put("name", new LocalizeString("Name", "Tên"));
    localizeDB.put("email", new LocalizeString("Email", "Thư điện tử"));
    localizeDB.put("select_photo", new LocalizeString("Select a photo", "Chọn ảnh"));
    localizeDB.put("submit_form", new LocalizeString("Submit form", "Gửi form"));
    localizeDB.put("name_size_between_5_30", new LocalizeString("Name must between 5 and 30", "Tên cần có độ dài từ 5 đến 30 ký tự"));
    localizeDB.put("email.cannot.null", new LocalizeString("Email cannot be null", "Thư điện tử không được trống"));
    localizeDB.put("email.invalid", new LocalizeString("Email is invalid", "Thư điện tử không hợp lệ"));
    localizeDB.put("photo.required", new LocalizeString("Photo is required", "Cần chọn 1 file ảnh"));
  }
  @Override
  public String getMessage(String code, Object[] args, String defaultMessage, Locale locale) {
    LocalizeString localizeString = localizeDB.get(code);
    if (localizeString == null ) return defaultMessage;
    
    switch (locale.getLanguage()) {
      case "vn":
        return localizeString.getVn();
      case "en":
        return localizeString.getEn();
      default:
        return defaultMessage;
    }
  }

  @Override
  public String getMessage(String code, Object[] args, Locale locale) throws NoSuchMessageException {
    LocalizeString localizeString = localizeDB.get(code);
    if (localizeString == null ) return code;

    switch (locale.getLanguage()) {
      case "vn":
        return localizeString.getVn();
      case "en":
        return localizeString.getEn();
      default:
        return code;
    }   
  }

  @Override
  public String getMessage(MessageSourceResolvable resolvable, Locale locale) throws NoSuchMessageException {
    return resolvable.getDefaultMessage();
  }
  
}
