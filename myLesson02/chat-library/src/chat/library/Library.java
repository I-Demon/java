package chat.library;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class Library {
    /*
/auth_request±login±password
/auth_accept±nickname
/auth_error
/broadcast±msg
/msg_format_error±msg
* */
    public static final String DELIMITER = "±";
    public static final String AUTH_REQUEST = "/auth_request";
    public static final String AUTH_ACCEPT = "/auth_accept";
    public static final String AUTH_DENIED = "/auth_denied";
    public static final String MSG_FORMAT_ERROR = "/msg_format_error";
    // если мы вдруг не поняли, что за сообщение и не смогли разобрать
    public static final String TYPE_BROADCAST = "/bcast";
    // то есть сообщение, которое будет посылаться всем

    public static String getAuthRequest(String login, String password) {
        return AUTH_REQUEST + DELIMITER + login + DELIMITER + password;
    }

    public static String getAuthAccept(String nickname) {
        return AUTH_ACCEPT + DELIMITER + nickname;
    }

    public static String getAuthDenied() {
        return AUTH_DENIED;
    }

    public static String getMsgFormatError(String message) {
        return MSG_FORMAT_ERROR + DELIMITER + message;
    }

    public static String getTypeBroadcast(String src, String message) {
        return TYPE_BROADCAST + DELIMITER + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(System.currentTimeMillis()) +
                DELIMITER + src + DELIMITER + message;
    }

    public static String getDecipheredMessage(String message) {
        String msg  = "";
        String[] arr = message.split(Library.DELIMITER);
        if (arr.length == 0 ) {
            return msg;
        }
        switch (arr[0]) {
            case AUTH_ACCEPT:
                msg = "Подключился новый пользователь: " + arr[1];
                break;
            case AUTH_DENIED:
                msg = "Доступ запрещен";
                break;
            case MSG_FORMAT_ERROR:
                msg = "Не верный формат сообщения: " + arr[1];
                break;
            case TYPE_BROADCAST:
                msg =  arr[1] + "  " + arr[2] + "  " + arr[3];
                break;
            default: msg = message;
                break;
        }
       return msg;
    }

}

