package client.views.utils.other;

public enum Message {
     CANCEL(1, "If you cancel, any change won't be made"),
     UPDATE(2,"are you sure you want to save changes?"),
     DELETE(3,"are you sure you want to proceed with the deletion?"),
     EMPTY_FIELDS(3,"The fields can not be empty");

     private  int num;
     private  String message;

     private Message(int num, String message) {
          this.num = num;
          this.message = message;
     }

     public String getMessage() {
          return message;
     }

     @Override
     public String toString() {
          return message;
     }
}

