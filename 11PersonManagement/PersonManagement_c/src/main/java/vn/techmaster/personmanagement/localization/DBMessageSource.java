package vn.techmaster.personmanagement.localization;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;
import vn.techmaster.personmanagement.model.LocalizeString;

import java.util.HashMap;
import java.util.Locale;

//Implement Messeage Source, tạo phần dịch
public class DBMessageSource implements MessageSource {
    private HashMap<String, LocalizeString> localizeDB;

    public DBMessageSource() {
        localizeDB = new HashMap<>();

        localizeDB.put("name_size_between_5_30", new LocalizeString("name between 5-30", "Tên có 5-30 ký tự"));
        localizeDB.put("job.cannot.null", new LocalizeString("job can not be null", "Công việc không để trống"));
        localizeDB.put("birthDay.cannot.null", new LocalizeString("BirtDay can not be null", "Hãy chọn ngày sinh"));


        localizeDB.put("home", new LocalizeString("home", "Trang chính"));
        localizeDB.put("list_people", new LocalizeString("List People", "Danh sách người"));
        localizeDB.put("list_job", new LocalizeString("List Job", "Danh sách công việc"));
        localizeDB.put("add_person", new LocalizeString("Add Person", "Thêm người"));

        localizeDB.put("name", new LocalizeString("Name", "Tên"));
        localizeDB.put("job", new LocalizeString("Job", "Công việc"));
        localizeDB.put("gender", new LocalizeString("Gender", "Giới tính"));
        localizeDB.put("male", new LocalizeString("male", "nam"));
        localizeDB.put("female", new LocalizeString("female", "nữ"));
        localizeDB.put("birthday", new LocalizeString("birthDay", "Ngày sinh"));
        localizeDB.put("select_photo", new LocalizeString("Select a photo", "Chọn ảnh"));
        localizeDB.put("submit_form", new LocalizeString("submit", "Lưu"));
        localizeDB.put("upload_error", new LocalizeString("Error upload", "Lỗi tải ảnh"));
        localizeDB.put("photo.required", new LocalizeString("Photo is required", "Cần chọn 1 file ảnh"));
        localizeDB.put("edit", new LocalizeString("Edit", "Cập nhật"));
        localizeDB.put("delete", new LocalizeString("Delete", "Xóa"));


        localizeDB.put("add.new.job",new LocalizeString("Add a job","Thêm công việc"));
        localizeDB.put("job.list",new LocalizeString("Job List","Danh sách công việc"));
        localizeDB.put("job.exist",new LocalizeString("Job already exist","Công việc đã có"));
        localizeDB.put("id",new LocalizeString("ID","STT"));
        localizeDB.put("job_name",new LocalizeString("Name","Tên công việc"));
        localizeDB.put("action",new LocalizeString("Action","Hành động"));
    }

    @Override
    public String getMessage(String code, Object[] objects, String defaultMessage, Locale locale) {
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
    public String getMessage(String code, Object[] objects, Locale locale) throws NoSuchMessageException {
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
