package org.matteopauroso.managerook.entity;

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
public class TournamentPlayers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToMany
	@JoinColumn(name = "tournament_id", referencedColumnName = "id", nullable = false)
	private Tournament tournament;
	
	@ManyToMany
	@JoinColumn(name = "player_id", referencedColumnName = "id", nullable = false)
	private Player player;
	
}
