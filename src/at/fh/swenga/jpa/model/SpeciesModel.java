package at.fh.swenga.jpa.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "specieses")
public class SpeciesModel implements java.io.Serializable{

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name", unique = true, nullable = false, length = 45)
	private String name;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private List<TypeModel> typesSpecies;
	
	@Column(name = "baseHP")
	private int baseHealthPoints;
	
	@Column(name = "baseATK")
	private int baseAttack;
	
	@Column(name = "baseDEF")
	private int baseDefense;
	
	@Column(name = "baseSPATK")
	private int baseSpecialAttack;
	
	@Column(name = "baseSPDEF")
	private int baseSpecialDefense;
	
	@Column(name = "baseSPE")
	private int baseSpeed;	

	@Version
	long version;
	
	public SpeciesModel() {
		// TODO Auto-generated constructor stub
	}
	
	public SpeciesModel(String name, int baseHealthPoints, int baseAttack, int baseDefense, int baseSpecialAttack,
			int baseSpecialDefense, int baseSpeed) {
		super();
		this.name = name;
		this.baseHealthPoints = baseHealthPoints;
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseSpecialAttack = baseSpecialAttack;
		this.baseSpecialDefense = baseSpecialDefense;
		this.baseSpeed = baseSpeed;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TypeModel> getTypes() {
		return typesSpecies;
	}

	public void setTypes(List<TypeModel> types) {
		this.typesSpecies = types;
	}
	

	public int getBaseHealthPoints() {
		return baseHealthPoints;
	}

	public void setBaseHealthPoints(int baseHealthPoints) {
		this.baseHealthPoints = baseHealthPoints;
	}

	public int getBaseAttack() {
		return baseAttack;
	}

	public void setBaseAttack(int baseAttack) {
		this.baseAttack = baseAttack;
	}

	public int getBaseDefense() {
		return baseDefense;
	}

	public void setBaseDefense(int baseDefense) {
		this.baseDefense = baseDefense;
	}

	public int getBaseSpecialAttack() {
		return baseSpecialAttack;
	}

	public void setBaseSpecialAttack(int baseSpecialAttack) {
		this.baseSpecialAttack = baseSpecialAttack;
	}

	public int getBaseSpecialDefense() {
		return baseSpecialDefense;
	}

	public void setBaseSpecialDefense(int baseSpecialDefense) {
		this.baseSpecialDefense = baseSpecialDefense;
	}

	public int getBaseSpeed() {
		return baseSpeed;
	}

	public void setBaseSpeed(int baseSpeed) {
		this.baseSpeed = baseSpeed;
	}

	public int getId() {
		return id;
	}
	
	public void addType(TypeModel type) {
		if (typesSpecies== null) {
			typesSpecies= new ArrayList<TypeModel>();
		}
		typesSpecies.add(type);
	}
}
