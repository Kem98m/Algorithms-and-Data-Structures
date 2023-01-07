

/**
 * Celestial Body class for NBody
 * @author Kenneth Marenco
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Copy constructor: copy instance variables from one
	 * body to this body
	 * @param b used to initialize this body
	 */
	public CelestialBody(CelestialBody b){
		this.myXPos = b.getX();
		this.myXVel = b.getXVel();
		this.myYPos = b.getY();
		this.myYVel = b.getYVel();
		this.myMass = b.getMass();
		this.myFileName = b.getName();
	}

	public double getX() {
		return this.myXPos;
	}
	public double getY() {
		return this.myYPos;
	}
	public double getXVel() {
		return this.myXVel;
	}
	/**
	 * Return y-velocity of this Body.
	 * @return value of y-velocity.
	 */
	public double getYVel() {
		return this.myYVel;
	}
	
	public double getMass() {
		return this.myMass;
	}
	public String getName() {
		return this.myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		return Math.sqrt(Math.pow(this.myXPos-b.getX(),2)+Math.pow(this.myYPos-b.getY(),2));
	}

	public double calcForceExertedBy(CelestialBody b) {
		double G = 6.67*Math.pow(10, -11);
		return (G*this.myMass*b.getMass())/Math.pow(calcDistance(b),2);
	}

	public double calcForceExertedByX(CelestialBody b) {
		return ((calcForceExertedBy(b))*(b.getX()-this.myXPos))/(calcDistance(b));
	}
	public double calcForceExertedByY(CelestialBody b) {
		return ((calcForceExertedBy(b))*(b.getY()-this.myYPos))/(calcDistance(b));
	}

	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double Fx = 0.0;
		for (CelestialBody b : bodies) {
			if (! b.equals(this)) {
				Fx = Fx + ((calcForceExertedBy(b))*(b.getX()-this.myXPos))/(calcDistance(b));
			}
		}
		return Fx;
	}

	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double Fy = 0.0;
		for (CelestialBody b : bodies) {
			if (! b.equals(this)) {
				Fy = Fy + ((calcForceExertedBy(b))*(b.getY()-this.myYPos))/(calcDistance(b));
			}
		}
		return Fy;
	}

	public void update(double deltaT, 
			           double xforce, double yforce) {
		double ax = xforce/myMass;
		double ay = yforce/myMass;
		double nvx = myXVel + deltaT*ax;
		double nvy = myYVel + deltaT*ay;
		double nx = myXPos + deltaT*nvx;
		double ny = myYPos + deltaT*nvy;
		myXPos = nx;
		myYPos = ny;
		myXVel = nvx;
		myYVel = nvy;
	}

	public void draw() {
		// TODO: complete method
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
