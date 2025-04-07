package org.matteopauroso.managerook.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "match")
public class Tournament {
	
	private enum Status{
		UPCOMING, ONGOING, FINISHED 
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	@Column(name = "start", nullable = false)
	private LocalDateTime start;
	
	@Column(name = "end", nullable = false)
	private LocalDateTime end;
	
	@ManyToMany
	@JoinColumn(name = "creator_id", referencedColumnName = "id", nullable = false)
	private Player creator;
	
	@ManyToMany
	@JoinColumn(name = "winner", referencedColumnName = "id")
	private Player winner;

	@Column(name = "status", nullable = false)
	private Status status;
	
}
