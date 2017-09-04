package hr.tvz.gudicek.elumen.elumenapi.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "text")
	private String text;

	@Column(name = "explanation")
	private String explanation;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;

	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	private List<Answer> answerList;

}
