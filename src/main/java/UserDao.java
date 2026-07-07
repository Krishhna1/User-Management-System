import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

    public int save(User user) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.persist(user);

            tx.commit();

            return 1;

        } catch (Exception e) {

            if (tx != null)
                tx.rollback();

            e.printStackTrace();

            return 0;
        }
    }

    public User selectUser(int id) {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.find(User.class, id);

        }
    }

    public List<User> getAllUsers() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            return session.createQuery("FROM User", User.class).list();

        }

    }

    public boolean updateUser(User user) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            session.merge(user);

            tx.commit();

            return true;

        } catch (Exception e) {

            if (tx != null)
                tx.rollback();

            e.printStackTrace();

            return false;
        }

    }

    public boolean deleteUser(int id) {

        Transaction tx = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            tx = session.beginTransaction();

            User user = session.find(User.class, id);

            if (user != null) {

                session.remove(user);

                tx.commit();

                return true;

            }

        } catch (Exception e) {

            if (tx != null)
                tx.rollback();

            e.printStackTrace();

        }

        return false;

    }

}