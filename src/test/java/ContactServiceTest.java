import org.junit.Test;

public class ContactServiceTest {
  @Test(expected = IllegalArgumentException.class)
  public void creerContact1() throws Exception {
    ContactService cs = new ContactService();
    // nom vide || null -> KO
    cs.creerContact(null, "06040141212");
  }

  @Test(expected = IllegalArgumentException.class)
  public void creerContact2() throws Exception {
    ContactService cs = new ContactService();
    // nom 2 car || 1 -> KO
    cs.creerContact("bj", "06040141212");
  }

  @Test
  public void creerContact3() throws Exception {
    ContactService cs = new ContactService();
    // nom 3-40 car -> OK
    cs.creerContact("kessab", "06040141212");
  }

  @Test(expected = ContactExistException.class)
  public void creerContact4() throws Exception {
    ContactService cs = new ContactService();
    // nom en double -> KO
    cs.creerContact("kessab", "06040141212");
    cs.creerContact("kessab", "06040141212");
  }

  @Test(expected = IllegalArgumentException.class)
  public void creerContact5() throws Exception {
    ContactService cs = new ContactService();
    // nom > 40 -> KO
    cs.creerContact("01234567890123456789012345678901234567890", "06040141212");
  }
}
