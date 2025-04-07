package org.matteopauroso.managerook.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
@Table(name = "elo_history")
public class EloHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "player_id", referencedColumnName = "id", nullable = false)
	private Player player;
	
	@Column(name = "old_elo", nullable = false)
	private long oldElo;
	
	@Column(name = "new_elo", nullable = false)
	private long newElo;
	
	@ManyToMany
	@JoinColumn(name = "match_id", referencedColumnName = "id", nullable = false)
	private Match match;
	
	@Column(name = "changed_at")
	private LocalDateTime changedAt = LocalDateTime.now();
	
}
