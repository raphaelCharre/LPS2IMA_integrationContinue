package contact;

public class ContactExistException extends Exception {
  private static final long serialVersionUID = 1L;

  ContactExistException() {
    super();
  }

  ContactExistException(String e) {
    super(e);
  }
}
