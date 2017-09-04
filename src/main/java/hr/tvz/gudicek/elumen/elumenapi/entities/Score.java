package hr.tvz.gudicek.elumen.elumenapi.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "score")
public class Score implements Serializable {

	private static final long serialVersionUID = -576457754090156018L;

	public Score(BigDecimal score, int roundNumber, User user, Subject subject) {
		super();
		this.score = score;
		this.roundNumber = roundNumber;
		this.user = user;
		this.subject = subject;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "score")
	private BigDecimal score;

	@Column(name = "round_number")
	private int roundNumber;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

}
