package it.uniroma3.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "orders")
public class Order {
	
	final String statusOpen = "open";
	final String statusClosed = "closed";
	final String statusFilled = "filled";

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date creationTime;
	@Temporal(TemporalType.TIMESTAMP)
	Date closureTime;
	@Temporal(TemporalType.TIMESTAMP)
	Date fillingTime;
	@Column(nullable=false)
	String status;
	
	//associazione order-customer : molti a uno ==> owner = order;    visibilità bidirezionale (quindi in customer, "mapped by customer")
	@ManyToOne(fetch=FetchType.LAZY)
	Customer customer;
		
	//associazione order-orderLine: uno a molti ==> owner=orderLine;   visibilità unidirezionale order->orderLine
	@OneToMany(fetch=FetchType.EAGER, cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	List<OrderLine> orderLines;
	
	
	public Order() {
		this.status = statusOpen;
	}
	
	public Order(Date creationTime) {
        this.creationTime = creationTime;
        this.status = statusOpen;
	}


	public void close(Date closureTime) {
        this.closureTime = closureTime;
        this.status = statusClosed;
	}
	
	
	public void addOrderLine(OrderLine ol) {
		this.orderLines.add(ol);
	}
	
	public void fill(Date fillingTime) {
        this.fillingTime = fillingTime;
        this.status = statusFilled;
	}
	
	//	getters & setters

	public Long getId() {
		return id;
	}

	public Date getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	

	public Date getClosureTime() {
		return closureTime;
	}

	public void setClosureTime(Date closureTime) {
		this.closureTime = closureTime;
	}
	
	
	public Date getFillingTime() {
		return this.fillingTime;
	}

	public void setFillingTime(Date fillingTime) {
		this.fillingTime = fillingTime;
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatusClosed() {
		this.status = this.statusClosed;
	}
	
	public void setStatusFilled() {
		this.status = this.statusFilled;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}