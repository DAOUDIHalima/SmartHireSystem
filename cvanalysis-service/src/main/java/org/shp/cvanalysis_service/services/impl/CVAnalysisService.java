package org.shp.cvanalysis_service.services.impl;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;
import org.shp.cvanalysis_service.models.CVAnalysisResult;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.python.util.PythonInterpreter;  // For spaCy integration

@Service
public class CVAnalysisService {

    private final Tika tika = new Tika();
    private final PythonInterpreter pyInterpreter = new PythonInterpreter(); // Python interpreter to run spaCy code

    public CVAnalysisResult analyzeCV(String cvFilePath) {
        // Extract text from CV using Apache Tika
        String extractedText = extractTextFromCV(cvFilePath);

        // Use NLP to extract fields from the text
        Set<String> skills = extractSkillsWithSpaCy(extractedText);  // Use spaCy or NLTK to extract skills
        int experienceYears = extractExperienceYearsWithSpaCy(extractedText);
        String educationLevel = extractEducationLevelWithSpaCy(extractedText);
        String location = extractLocationWithSpaCy(extractedText);

        // Build and return the analysis result
        CVAnalysisResult analysisResult = new CVAnalysisResult();
        analysisResult.setSkills(skills);
        analysisResult.setExperienceYears(experienceYears);
        analysisResult.setEducationLevel(educationLevel);
        analysisResult.setLocation(location);

        return analysisResult;
    }

    private String extractTextFromCV(String cvFilePath) {
        try (FileInputStream fis = new FileInputStream(new File(cvFilePath))) {
            // Extract text from CV using Apache Tika
            return tika.parseToString(fis);  // Passing InputStream here
        } catch (IOException | TikaException e) {
            e.printStackTrace();
            return "";
        }
    }

    // Use spaCy to extract skills from the CV text
    private Set<String> extractSkillsWithSpaCy(String text) {
        // Sample Python spaCy code integrated via Java
        pyInterpreter.exec("import spacy");
        pyInterpreter.exec("nlp = spacy.load('en_core_web_sm')");
        pyInterpreter.set("cv_text", text);

        // Use spaCy to extract named entities or specific tokens representing skills
        pyInterpreter.exec("doc = nlp(cv_text)");
        pyInterpreter.exec("skills = set([ent.text for ent in doc.ents if ent.label_ == 'SKILL'])");

        // Retrieve the skills from the Python environment
        Set<String> skills = (Set<String>) pyInterpreter.get("skills", Set.class);
        return skills != null ? skills : new HashSet<>();
    }

    private int extractExperienceYearsWithSpaCy(String text) {
        // Use spaCy to extract years of experience (or custom logic)
        pyInterpreter.set("cv_text", text);
        pyInterpreter.exec("experience_years = 5  # Placeholder NLP logic to extract experience");

        return (int) pyInterpreter.get("experience_years", Integer.class);
    }

    private String extractEducationLevelWithSpaCy(String text) {
        // Use spaCy to extract education level (e.g., Bachelor's, Master's)
        pyInterpreter.set("cv_text", text);
        pyInterpreter.exec("education_level = 'Bachelor's Degree'  # Placeholder for NLP logic");

        return (String) pyInterpreter.get("education_level", String.class);
    }

    private String extractLocationWithSpaCy(String text) {
        // Use spaCy to extract location information
        pyInterpreter.set("cv_text", text);
        pyInterpreter.exec("location = 'New York'  # Placeholder for NLP location extraction");

        return (String) pyInterpreter.get("location", String.class);
    }
}
