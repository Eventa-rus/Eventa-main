import java.util.Date;
import java.util.ArrayList;

public class base {
	public static void main (String args[]) {

		Registration reg = new Registration("ivan","ivanov","hikm@gmail.com");
		try {
			reg.registration();
		}
		catch (RegistrationError e) {
			System.out.println(e);
		}
	}
}

class RegistrationError extends Exception
{
      public RegistrationError() {}

      public RegistrationError(String message)
      {
         super(message);
      }
}

class Registration {
	private String username;
	private String password;
	private String email;
	
	public Registration(String username,String password,String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	private boolean isValid() {
		return true;
	}
	
	public void registration() throws RegistrationError {
		if (this.isValid())	{
			System.out.println("Registration");
			// send to registration
		}
		else {
			throw new RegistrationError("Invalid fields");
		}
	}
}

class BaseProfile {
	private String id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private boolean isOnline;
	private String img;
    
    public BaseProfile(String id, String firstName, String lastName, Date birthday, boolean isOnline, String img) {
        this.id = id;
	    this.firstName = firstName;
        this.lastName = lastName;
	    this.birthday = birthday;
	    this.isOnline = isOnline;
	    this.img = img;
    }
	
	public String getName() {
		return this.firstName+" "+this.lastName;
	}
}

class Profile extends BaseProfile {
	private String ability;
	private ArrayList<BaseProfile> friends;
	private ArrayList<Rate> rates;
	private ArrayList<Comment> comments;
	private ArrayList<Action> actions;
	private Statistic statistic;

	public Profile(String id, String firstName, String lastName, Date birthday,
					boolean isOnline, String img, String ability, ArrayList<BaseProfile> frieds) {
		super(id,firstName,lastName,birthday,isOnline,img);
	    this.ability = ability;
	    this.friends = friends;
	    this.rates = new ArrayList<Rate>();
	    this.comments = new ArrayList<Comment>();
	    this.actions = new ArrayList<Action>();
	}
}

class User {
	private Profile profile;
	private GPSPoint position;
	
	public User(Profile profile) {
		this.profile = profile;
	}
	public void setPosition(GPSPoint position){
		this.position = position;
	}
}
class GPSPoint {
	private float longitude;
	private float latitude;
	
	public GPSPoint (float longitude, float latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}
}

class Session {
	private String token;
	private Date lastLogin;
	private Date expire;
	private User user;
	
	private Session(String token, Date lastLogin, Date expire, User user) {
		this.token = token;
		this.lastLogin = new Date();
		this.expire = expire;
		this.user = user;
	}
	
	public static Session login (String username, String password) {
		//send to login server form
		
		//get all from JSON or throw Unauthorized exception! 
		return new Session("aa",new Date(),new Date(),null);
	}
}

class Unauthorized extends Exception
{
    public Unauthorized() {}

    public Unauthorized(String message)
    {
       super(message);
    }
}

class Comment {
	private BaseProfile author;
	private String text;
	private Date createdAt;
	
	public Comment(BaseProfile author, String text, Date createdAt) {
		this.author = author;
		this.text = text;
		this.createdAt = createdAt;
	}
}

class Rate {
	private BaseProfile profile;
	private int rate;
	private Date createdAt;
	
	public Rate(BaseProfile profile, int rate, Date createdAt) {
		this.profile = profile;
		this.rate = rate;
		this.createdAt = createdAt;
	}
}

class Statistic {
	private String statistic;

	public Statistic(String statistic){
		this.statistic = statistic;
	}
}

class Action {
	private BaseAppeal appeal;
	private Date createdAt;
}

class BaseAppeal {
	private String id; 
	private BaseProfile profile;
	private String dectription;
	private boolean isActive;
	private Date createdAt;
	private Date date;
	private Award award;
	private int countHelpers;
	private GPSPoint position;

	public BaseAppeal (String id, BaseProfile profile, String dectription,boolean isActive, Date createdAt, Award award, int countHelpers, GPSPoint position) {
		this.id = id;
		this.profile = profile;
		this.dectription = dectription;
		this.isActive = isActive;
		this.createdAt = createdAt;
		this.award = award;
		this.countHelpers = countHelpers;
		this.position = position;
	}
}

class Appeal extends BaseAppeal {
	private String text;
	private ArrayList<Comment> comments;
	private ArrayList<BaseProfile> helpers;

	public Appeal(String id, BaseProfile profile, String dectription, boolean isActive, Date createdAt, Award award,
		int countHelpers, GPSPoint position, String text) {
		super(id,profile,dectription,isActive,createdAt,award,countHelpers,position);
		this.text = text;
	}
}

interface Award {
	void display();
}

class ThanksAward implements Award {
	public void display() {
		System.out.println("Thanks!");
	}
}

class СookiesAward implements Award {
	public void display() {
		System.out.println("Do you want cookies?");
	}
}

class DebtorAward implements Award {
	public void display() {
		System.out.println("I'm debtor!");
	}
}

class MoneyAward implements Award {

	private float money;
	public MoneyAward(float money) {
		this.money = money;
	}
	public void display() {
		System.out.println("I pay "+money+"$");
	}
}
