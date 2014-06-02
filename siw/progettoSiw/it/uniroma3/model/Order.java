package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Orders")
public class Order {
	public final static int OPEN = 1;
	public final static int CLOSED = 2;
	public final static int EVADED = 3;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@ManyToOne
	@Column(nullable= false)
	private Customer customer;
	@OneToMany(cascade= {CascadeType.REMOVE})
	@Column(nullable= false)
	@JoinColumn(name = "orders_id")
	private List<OrderLine> orderLines;
	@Column(nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationTime;
	@Column(nullable= false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date evadedTime;
	@Column(nullable= false)
	private int state;
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state; 
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getEndTime() {  
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getEvadedTime() {
		return evadedTime;
	}
	public void setEvadedTime(Date evadedTime) {
		this.evadedTime = evadedTime;
	}

}
