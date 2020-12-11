package com.ora.system;

import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

import com.ora.dao.UserDAO;
import com.ora.dao.UserDAOImpl;
import com.ora.entity.Feedback;
import com.ora.entity.Mechanic;
import com.ora.entity.Service;
import com.ora.entity.User;
import com.ora.exception.InvalidException;
import com.ora.exception.InvalidFeedbackException;
import com.ora.exception.InvalidRequestException;
import com.ora.exception.MechanicNotFoundException;
import com.ora.exception.UserNotFoundException;
import com.ora.service.AdminService;
import com.ora.service.AdminServiceImpl;
import com.ora.service.MechanicService;
import com.ora.service.MechanicServiceImpl;
import com.ora.service.UserService;
import com.ora.service.UserServiceImpl;
import com.ora.validate.Validator;

public class MainClass {

	public static void main(String[] args) throws UserNotFoundException, MechanicNotFoundException {

		AdminService ads = new AdminServiceImpl();
		MechanicService mcn = new MechanicServiceImpl();
		UserService ucn = new UserServiceImpl();
		Validator v = new Validator();
		

		Scanner scn = new Scanner(System.in);
		System.out.println("On Road Vehicle Breakdown Assistance");
		System.out.println("-----------------------------------------------------------");
		System.out.println("1.Admin");
		System.out.println("2.Mechanic");
		System.out.println("3.User");
		System.out.println("4.Exit");
		System.out.println("Enter Choice:");
		int choice = scn.nextInt();
		char yans;
		switch (choice) {
		case 1:
			System.out.println("Welcome for Admin Login");
			System.out.println("-----------------------------------------------------------");
			scn.nextLine();
			System.out.println("Enter Admin Name");
			String adminId = scn.nextLine();
			System.out.println("Enter Password");
			String adminpassword = scn.nextLine();
			boolean admin = v.validateAdmin(adminId, adminpassword);
			if (admin) {
				System.out.println("Welcome Admin ");
				System.out.println("-----------------------------------------------------------");
				do {
					System.out.println(
							"1.View Mechanic\n2.View User\n3.View Feedback\n4.AllowOrBlockMechanic\n5.Close\n");
					System.out.println("Enter choice:");
					int choice1 = scn.nextInt();
					switch (choice1) {
					case 1:
						List<Mechanic> list = ads.viewMechanicDetails();
						System.out.println("-------------Displaying Mechanic Details------------");
						System.out.println();
						System.out.println("Mechanic Name" + "\t" + "Mechanic Email Id" + "\t" + "Mechanic Phone Number"
								+ "\t" + "Mechanic Service Type" + "\t" + "Mechanic location");
						for (Mechanic m : list) {
							System.out.println(m.getMechanicName() + "\t\t" + m.getMechanicEmailId() + "\t\t"
									+ m.getMechanicPhoneNumber() + "\t\t" + m.getMechanichServiceType() + "\t\t"
									+ m.getLocation());
						}

						break;

					case 2:
						List<User> list11 = ads.viewUserDetails();
						System.out.println("-------------Displaying User Details------------");
						System.out.println();
						System.out.println("User Name" + "\t" + "User Email Id" + "\t" + "User Phone Number");
						for (User u : list11) {
							System.out.println(
									u.getUserName() + "\t" + u.getUserEmailId() + "\t" + u.getUserPhoneNumber());
						}
						break;

					case 3:
						List<Feedback> list12 = ads.viewFeedback();
						System.out.println("-------------Displaying Feedback Details------------");
						System.out.println();
						System.out.println("User Id" + "\t" + "Mechanic Id" + "\t" + "Feedback" + "\t" + "Ratings");
						for (Feedback f : list12) {
							System.out.println(f.getUserId() + "\t" + f.getMechanicId() + "\t" + f.getFeedback() + "\t"
									+ f.getRatings());
						}
						break;
					case 4:
						System.out.println("Enter Mechanic Id");
						int mechid=scn.nextInt();
						boolean check=ads.allowOrBlockMechanic(mechid);
						if(check) {
							System.out.println("Mechanic is eligible to stay");
						}
						else {
							System.out.println("Mechanic Blocked");
						}
						break;
					}

					if (choice1 == 5) {
						System.out.println("Do You Want To Continue?(y/n)");
						yans = scn.next().charAt(0);
						if (yans == 'y') {
							System.out.println("1.Admin");
							System.out.println("2.Mechanic");
							System.out.println("3.User");
							System.out.println("4.Exit");
							System.out.println("Enter Choice:");
							choice = scn.nextInt();
						}
						else {
							System.exit(0);
						}
					}

				} while (true);

			} else {
				System.out.println("Invalid Details");

			}
			break;
		case 2:
			System.out.println("1.Welcome into Mechanic");
			System.out.println("-----------------------------------------------------------");
			System.out.println("1.Register\n2.Login");
			System.out.println("Enter your choice:");
			int choice3 = scn.nextInt();
			switch (choice3) {
			case 1:
				System.out.println("Enter the id:");
				int mId = scn.nextInt();
				scn.nextLine();
				System.out.println("Enter the Name: ");
				String mname = scn.nextLine();
				System.out.println("Enter the Password: ");
				String mpass = scn.nextLine();
				System.out.println("Enter the Email: ");
				String memail = scn.nextLine();
				System.out.println("Enter the Phone Number: ");
				BigInteger phone = scn.nextBigInteger();
				scn.nextLine();
				System.out.println("Enter the Service Type: ");
				String servicetype = scn.nextLine();
				System.out.println("Enter the Location: ");
				String location = scn.next();
				try {
					Mechanic mcnentity = new Mechanic(mId, mname, mpass, memail, phone, servicetype, location);
					boolean add = mcn.addMechanic(mcnentity);
					if (add) {
						System.out.println("Mechanic Added Successfully");
					} else {
						throw new InvalidException("Mechanic Not Added");
					}
				} catch (InvalidException e) {
					e.printStackTrace();

				}
				
			case 2:
				System.out.println("Welcome for Mechanic Login");
				System.out.println("-----------------------------------------------------------");
				scn.nextLine();
				System.out.println("Enter Mechanic Id");
				int mechanicId = scn.nextInt();
				scn.nextLine();
				System.out.println("Enter Password");
				String mechanicpassword = scn.nextLine();
				boolean mechanic = v.validateMechanic(mechanicId, mechanicpassword);
				if (mechanic) {
					do {
						System.out.println("Welcome Mechanic");
						System.out.println("-----------------------------------------------------");
						System.out.println("1.View Request\n2.View Feedback\n3.Exit\n");
						System.out.println("Enter choice:");
						int choice4 = scn.nextInt();
						switch (choice4) {
						case 1:
							List<Service> list4 = mcn.viewRequest(mechanicId);
							
							System.out.println("-------------Displaying Request Details------------");
							System.out.println();
							System.out.println("UserId" + "\t" + "Service Type" + "\t" + "Location");
							for (Service s : list4) {
								System.out.println(
										s.getUserId() + "\t\t" + s.getServiceType() + "\t\t" + s.getLocation());
							}
							

							break;
						case 2:
							List<Feedback> list5 = mcn.viewFeedback(mechanicId);
							System.out.println("-------------Displaying Feedback Details------------");
							System.out.println();
							System.out.println("UserId" + "\t" + "Mechanic Id" + "\t" + "Feedback" + "\t" + "Ratings");
							for (Feedback f : list5) {
								System.out.println(f.getUserId() + "\t\t" + f.getMechanicId() + "\t\t" + f.getFeedback()
										+ "\t\t" + f.getRatings());
							}
							break;
						}
						if (choice4 == 3) {
							System.out.println("Do You Want To Continue?(y/n)");
							yans = scn.next().charAt(0);
							if (yans == 'y') {
								System.out.println("1.Admin");
								System.out.println("2.Mechanic");
								System.out.println("3.User");
								System.out.println("4.Exit");
								System.out.println("Enter Choice:");
								choice = scn.nextInt();
							}
							else {
								System.exit(0);
							}
						}

					} while (true);
				} else {
					System.out.println("Invalid Details");
				}
				
				}
				break;
			case 3:
				System.out.println("1.Welcome into User");
				System.out.println("-----------------------------------------------------------");
				System.out.println("1.Register\n2.Login");
				System.out.println("Enter your choice:");
				int choice5 = scn.nextInt();
				switch (choice5) {
				case 1:
					System.out.println("Enter the Id: ");
					int uid = scn.nextInt();
					scn.nextLine();
					System.out.println("Enter the Name: ");
					String uname = scn.nextLine();
					System.out.println("Enter the Password: ");
					String upass = scn.nextLine();
					System.out.println("Enter the Email: ");
					String uemail = scn.nextLine();
					System.out.println("Enter the Phone Number: ");
					BigInteger phone = scn.nextBigInteger();
					scn.nextLine();
					try {
						User user = new User(uid, uname, upass, uemail, phone);
						boolean add = ucn.addUser(user);
						if (add) {
							System.out.println("User Added Successfully");

						} else {
							throw new InvalidException("User Not Added");
						}

					} catch (InvalidException e) {
						e.printStackTrace();

					}
				
				case 2:
					System.out.println("Welcome for User Login");
					System.out.println("-----------------------------------------------------------");
					scn.nextLine();
					System.out.println("Enter User Id");
					int userId = scn.nextInt();
					scn.nextLine();
					System.out.println("Enter Password");
					String userpassword = scn.nextLine();
					boolean valUser = v.validateUser(userId, userpassword);
					if (valUser) {
						do {
							System.out.println("Welcome User");

							System.out.println(
									"1.Update User\n2.Search Mechanic\n3.Add Request\n4.Give Feedback\n5.Exit\n");
							System.out.println("Enter your choice:");
							int choice6 = scn.nextInt();
							switch (choice6) {
							case 1:
								System.out.println("Enter the Id for update: ");
								int userid = scn.nextInt();
								scn.nextLine();
								System.out.println("Enter the Name: ");
								String username = scn.nextLine();
								System.out.println("Enter the Password: ");
								String userpass = scn.nextLine();
								System.out.println("Enter the Email: ");
								String useremail = scn.nextLine();
								System.out.println("Enter the Phone Number: ");
								BigInteger userphone = scn.nextBigInteger();
								scn.nextLine();
								User user1 = new User(userid, username, userpass, useremail, userphone);
								try {
									boolean valid = ucn.updateUser(user1);
									if (valid) {
										System.out.println("User Updated with id=" + userId);
									} else {
										throw new UserNotFoundException("User Not Updated");
									}

								} catch (UserNotFoundException e) {
									e.printStackTrace();
								}
								break;
							case 2: {
								System.out.println("Enter The Location: ");
								String location = scn.next();
								List<Mechanic> lm = ucn.searchMechanic(location);
								try {
									if (lm != null) {
										for (Mechanic m : lm) {
											System.out.println(m.toString());
										}
									} else {
										throw new MechanicNotFoundException("Mechanic Not Found");
									}
								} catch (MechanicNotFoundException m) {
									m.printStackTrace();
								}
							}
								break;
							case 3: {

								System.out.println("Enter user id:");
								int userId2 = scn.nextInt();
								System.out.println("Enter the mechanicId for service: ");
								int mid = scn.nextInt();
								scn.nextLine();
								System.out.println("Enter the service type:");
								String serviceType = scn.nextLine();
								
								System.out.println("Enter location:");
								String location = scn.next();
								Service service = new Service(mid, serviceType, userId2, location);
								try {
									boolean valid1 = ucn.addRequest(service);
									if (valid1) {
										System.out.println("Request added");
									} else {
										throw new InvalidRequestException("Request not added");
									}
								} catch (InvalidRequestException e) {
									e.printStackTrace();
								}

							}
								break;
							case 4: {
								System.out.println("Enter feedback id:");
								int fid = scn.nextInt();
								scn.nextLine();
								System.out.println("Enter feedback:");
								String feedback = scn.nextLine();
								System.out.println("Enter mechanic id:");
								int mechanicId = scn.nextInt();
								System.out.println("Enter ratings:");
								float ratings = scn.nextFloat();
								Feedback feed = new Feedback(fid, userId , mechanicId, feedback, ratings);
								try {
									boolean valid5 = ucn.giveFeedback(feed);
									if (valid5) {
										System.out.println("Feedback added successfully");
									} else {
										throw new NullPointerException("Mechanic with given id doesnt exist");
									}
								} catch (NullPointerException e) {
									e.printStackTrace();
								}
							}
								break;
							}
							if (choice6 == 5) {
								System.out.println("Do You Want To Continue?(y/n)");
								yans = scn.next().charAt(0);
								if (yans == 'y') {
									System.out.println("1.Admin");
									System.out.println("2.Mechanic");
									System.out.println("3.User");
									System.out.println("4.Exit");
									System.out.println("Enter Choice:");
									choice = scn.nextInt();
								}
								else {
									System.exit(0);
								}
							}

						} while (true);

					} else {
						System.out.println("Invalid Details");
					}
					
						

					
				}
			}
			
		}
	}
