package myproject.jointable.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import myproject.jointable.entity.CardPayment;
import myproject.jointable.entity.ChequePayment;
import myproject.jointable.entity.Payment;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/myproject/jointable/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
			builder = builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry = builder.build();
			sessionFactory = cfg.buildSessionFactory(registry);
			session = sessionFactory.openSession();
//			tx = session.beginTransaction();
//			CardPayment cp = new CardPayment();
//			cp.setTxId("T-111");
//			cp.setPayDate("14-04-2022");
//			cp.setPayAmt(2000);
//			cp.setCardNo(745218);
//			cp.setExrDate("20-08-2927");
//			
//			ChequePayment chp = new ChequePayment();
//			chp.setTxId("T-222");
//			chp.setPayDate("19-03-2021");
//			chp.setPayAmt(3200);
//			chp.setChequeNo(6523);
//			chp.setAccNo("4589");
//			
//			
//			String cardPk = (String) session.save(cp);
//			String chequePk = (String)session.save(chp);
//			
//			System.out.println("Card Pk : "+cardPk);
//			System.out.println("Cheque Pk : "+chequePk);
//			
//			tx.commit();
			
			CardPayment cp = (CardPayment)session.get(Payment.class, "T-111");
			System.out.println("-------------------------------------------Card Payment--------------------------------------------------");
			System.out.println(cp.getTxId());
			System.out.println(cp.getPayAmt());
			System.out.println(cp.getPayDate());
			System.out.println(cp.getCardNo());
			System.out.println(cp.getExrDate());
			
			System.out.println("----------------------------------------------------------------------------------------------------------");
			ChequePayment chp = (ChequePayment) session.get(Payment.class, "T-222");
			System.out.println(chp.getTxId());
			System.out.println(chp.getPayAmt());
			System.out.println(chp.getPayDate());
			System.out.println(chp.getChequeNo());
			System.out.println(chp.getAccNo());
			
			
			
		}catch (Exception e) {
//			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}
}
