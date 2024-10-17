import React, { useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const Apply = () => {
    const { id } = useParams();
    const [fullName, setFullName] = useState('');
    const [email, setEmail] = useState('');
    const [experience, setExperience] = useState(0);
    const [coverLetter, setCoverLetter] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        const application = { fullName, email, experience, coverLetter };
        try {
            await axios.post(`/api/applications/${id}`, application);
            alert('Application Submitted');
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <div className="apply-job">
            <h2>Apply for the Job</h2>
            <form onSubmit={handleSubmit}>
                <input type="text" placeholder="Full Name" value={fullName} onChange={(e) => setFullName(e.target.value)} />
                <input type="email" placeholder="Email" value={email} onChange={(e) => setEmail(e.target.value)} />
                <input type="number" placeholder="Experience Years" value={experience} onChange={(e) => setExperience(e.target.value)} />
                <textarea placeholder="Cover Letter" value={coverLetter} onChange={(e) => setCoverLetter(e.target.value)} />
                <button type="submit">Submit</button>
            </form>
        </div>
    );
};

export default Apply;
