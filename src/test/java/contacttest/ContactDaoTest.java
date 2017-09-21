package contacttest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import contact.Contact;
import contact.ContactDao;

public class ContactDaoTest {
  @Test
  public void creerContact() throws Exception {
    ContactDao dao = new ContactDao();
    Contact c = new Contact("Kessab", "");
    dao.creerContact(c);
  }

  @Test
  public void recupererContact() throws Exception {
    ContactDao dao = new ContactDao();
    Contact c = new Contact("Kessab", "");
    dao.creerContact(c);

    assertEquals(c, dao.recupererContact("Kessab"));
  }

  @Test
  public void isContactExiste() throws Exception {
    ContactDao dao = new ContactDao();
    Contact c = new Contact("Kessab", "");
    dao.creerContact(c);

    assertTrue(dao.isContactExiste("Kessab"));
    assertFalse(dao.isContactExiste("kesaz"));

  }

}