package de.tum.in.ase.eist;

import java.util.HashSet;
import java.util.Set;

public class Student extends Person implements Skill{
    private String matriculationNumber;
    private int semester;
    private Set<String> knowledge = new HashSet<>();
    private StudyLevel studyLevel;
    private Set<Skill> skills = new HashSet<>();

    public Student(String name, int age, String tumid, String matriculationNumber, StudyLevel studyLevel, int semester){
        super(name, age, tumid);
        this.matriculationNumber = matriculationNumber;
        this.semester = semester;
        this.studyLevel = studyLevel;
    }

    public void learnSkill(Skill skill) {
        skills.add(skill);
    }

    public void acquireKnowledge(String knowledgeToAdd) {
        knowledge.add(knowledgeToAdd);
    }

    @Override
    public void apply() {

    }

    public String getMatriculationNumber() {
        return matriculationNumber;
    }

    public int getSemester() {
        return semester;
    }

    public Set<String> getKnowledge() {
        return knowledge;
    }

    public StudyLevel getStudyLevel() {
        return studyLevel;
    }

    public Set<Skill> getSkills() {
        return skills;
    }
}
