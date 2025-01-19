package com.project.HotelApi.HostelApi.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bed_table")
public class BedTableEntity {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "bed_count")
	private String bedCount;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	//@JsonIgnore
	private PriceTableEntity priceTableEntity;
	
	
	
	public BedTableEntity() {
		super();
	}

	public BedTableEntity(int id, String bedCount) {
		super();
		this.id = id;
		this.bedCount = bedCount;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the bedCount
	 */
	public String getBedCount() {
		return bedCount;
	}

	/**
	 * @param bedCount the bedCount to set
	 */
	public void setBedCount(String bedCount) {
		this.bedCount = bedCount;
	}

	
	/**
	 * @return the priceTableEntity
	 */
	public PriceTableEntity getPriceTableEntity() {
		return priceTableEntity;
	}

	/**
	 * @param priceTableEntity the priceTableEntity to set
	 */
	public void setPriceTableEntity(PriceTableEntity priceTableEntity) {
		this.priceTableEntity = priceTableEntity;
	}

	@Override
	public String toString() {
		return "BedTableEntity [id=" + id + ", bedCount=" + bedCount + ", priceTableEntity=" + priceTableEntity + "]";
	}

	
	
}
