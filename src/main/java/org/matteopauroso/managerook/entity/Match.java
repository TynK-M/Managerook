package org.matteopauroso.managerook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "match")
public class Match {
	
	public enum Result {
		WHITE_WIN, BLACK_WIN, DRAW 
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "tournament_id", referencedColumnName = "id", nullable = false)
	private Tournament tournament;

	@ManyToOne
	@JoinColumn(name = "player_white_id", referencedColumnName = "id", nullable = false)	
	private Player playerWhite;

	@ManyToOne
	@JoinColumn(name = "player_black_id", referencedColumnName = "id", nullable = false)
	private Player playerBlack;
	
	@Column(name = "result", nullable = false)
	private Result result;
	
	@Column(name = "round_number", nullable = false)
	private long roundNumber;
	
}
