package com.m.g.puzzlers;
/**
        import java.util.ArrayList;
        import java.util.List;
        import org.apache.log4j.Logger;
        import org.fileUpload.model.UserInfo;
        import org.fileUpload.util.AppConstants;
        import org.fileUpload.util.ApplicationException;
        import org.hibernate.Criteria;
        import org.hibernate.Query;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.Transaction;
        import org.hibernate.criterion.Criterion;
        import org.hibernate.criterion.Restrictions;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Repository;
@Repository
public class UserDAOImpl implements UserDAO {
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(UserInfo user) {
        //Session session = HibernateUtil.getCurruntSession();
        Session session=null;
        Transaction tx=null;
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.merge(user);
            tx.commit();
        }catch (Exception e) {
            logger.error("Error at saving user information ", e);
            if (tx != null) {
                tx.rollback();
                throw new ApplicationException(1111,"Database Exception.");
            }
        }
    }

    public void updateUser(UserInfo user) {
        Session session=null;
        Transaction tx=null;
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            session.update(user);
            tx.commit();
        }catch (Exception e) {
            logger.error("Error at updating user information ", e);
            if (tx != null) {
                tx.rollback();
                throw new ApplicationException(1111,"Database Exception.");
            }
        }
    }

    public UserInfo findUserById(long id) {
        Session session=null;
        Transaction tx=null;
        UserInfo user =null;
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            user = (UserInfo) session.get(UserInfo.class, id);
            tx.commit();
        }catch (Exception e) {
            logger.error("Error at findUserById funtion ", e);
            if (tx != null) {
                tx.rollback();
                throw new ApplicationException(1111,"Database Exception.");
            }
        }
        return user;
    }

    /**
     * get user information using username
     * query is written as parameterized

    public UserInfo findUserByName(String username){
        Session session=null;
        Transaction tx=null;
        UserInfo user =null;
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();

*************************************************************************************************************

    ================= problem code start =====================

            Query query = session.createQuery(
                    "from UserInfo user where user.user_name='"+username+"'");

    Problem Description: Code dynamically constructs and executes a SQL query without filtering the user inputs.

    ================= problem code end =====================



    ================= better code start =====================

    Criteria crit = session.createCriteria(UserInfo.class);
    Criterion user_name = Restrictions.eq("user_name",username);
    crit.add(user_name);
    crit.setMaxResults(1);
    user = (UserInfo) crit.uniqueResult();]

    Solution Description: The solution is making proper use of JPA Query::setParameter() to set the parameter in the user search query.
    SetParameter() will take care of performing proper sanitization (in this case actually using PreparedStatement::setParameter() method behind the scenes).

    ================= better code end ====================

*************************************************************************************************************

      user = (UserInfo) query.uniqueResult();
            tx.commit();
        }catch (Exception e) {
            logger.error("Error at findUserByName funtion ", e);
            if (tx != null) {
                tx.rollback();
                throw new ApplicationException(1111,"Database Exception.");
            }
        }
        return user;
    }

    @SuppressWarnings("unchecked")
    public List<UserInfo> getUserList() {
        Session session=null;
        Transaction tx=null;
        List<UserInfo> userList = null;
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Query query = session.createQuery("from UserInfo");
            userList =(List<UserInfo>)query.list();
            tx.commit();
        }catch (Exception e) {
            logger.error("Error at getUserList funtion ", e);
            if (tx != null) {
                tx.rollback();
                throw new ApplicationException(1111,"Database Exception.");
            }
        }
        return userList;
    }

    public void deleteUser(long id) {
        Session session=null;
        Transaction tx=null;
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            UserInfo user = (UserInfo)session.get(UserInfo.class, id);
            session.delete(user);
            tx.commit();
        }catch (Exception e) {
            logger.error("Error at deleteUser funtion ", e);
            if (tx != null) {
                tx.rollback();
                throw new ApplicationException(1111,"Database Exception.");
            }
        }
    }

    public boolean isUserExist(String username) {
        //Session session = HibernateUtil.getCurruntSession();
        Session session=null;
        Transaction tx=null;
        Long count = Long.valueOf(0);
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Query query = session.createQuery(
                    "select count(*) from UserInfo user where user.user_name=:user_name");
            query.setString("user_name", username);
            count = (Long)query.uniqueResult();
            tx.commit();
        }catch (Exception e) {
            logger.error("Error at isUserExist funtion ", e);
            if (tx != null) {
                tx.rollback();
                throw new ApplicationException(1111,"Database Exception.");
            }
        }
        if(count>0) return true;
        return false;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<UserInfo> getUserListWithCustomerRole() {
        // Session session = HibernateUtil.getCurruntSession();
        Session session=null;
        Transaction tx=null;
        List<UserInfo> userList=new ArrayList<UserInfo> ();
        try{
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            Query query =session.createQuery("from UserInfo where role_id=:roleId");
            query.setLong("roleId", AppConstants.CUSTOMER_ROLE_ID);
            userList=(List<UserInfo>)query.list();
            tx.commit();
        }catch (Exception e) {
            logger.error("Error at getUserListWithCustomerRole funtion ", e);
            if (tx != null) {
                tx.rollback();
                throw new ApplicationException(1111,"Database Exception.");
            }
        }
        return userList;
    }
}
*/