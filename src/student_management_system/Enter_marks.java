package student_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Enter_marks extends JFrame implements ActionListener {
    
    Choice scroll;
    JComboBox<String> sem;
    JComboBox<String> s1,s2,s3,s4,s5;
    JTextField m1,m2,m3,m4,m5;
    JButton submit,cancel;
    
    Enter_marks(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon ig=new ImageIcon(ClassLoader.getSystemResource("img/exam.jpg"));
        Image igg=ig.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon  igc=new ImageIcon(igg);
        JLabel Jimg= new JLabel(igc);
        Jimg.setBounds(500, 40, 400, 300);
        add(Jimg);
        
        JLabel heading=new JLabel("Enter Marks of Student"); 
        heading.setBounds(30,30,400,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,25));
        add(heading);
        
        JLabel Stu_search =new JLabel("Select By Roll Number");
        Stu_search.setBounds(30,60,180,30);
        Stu_search.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(Stu_search);
        
        scroll=new Choice();
        scroll.setBounds(250,65,150,30);
        add(scroll);
        
        try{
            conn c=new conn();
            String Query="SELECT * FROM new_Student";
            ResultSet rs=c.s.executeQuery(Query);
            while(rs.next()){
                scroll.add(rs.getString("roll_no"));
            }
                    
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel semesters=new JLabel("Select Semester");
        semesters.setBounds(30,120 ,170 , 30);
        semesters.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(semesters);
            
        String[] semester={"","1st semester","2nd semester","3rd semester","4th semester","5th semester","6th semester","7th semester","8th semester",};
        sem=new JComboBox<>(semester);
        sem.setBounds(250,120,150,26);
        sem.setFont(new Font("Tahoma",Font.PLAIN,12));
        sem.setSelectedIndex(0);  
        sem.setBackground(Color.WHITE);
        add(sem);
        
        JLabel enter_Sub=new JLabel("Enter Subject");
        enter_Sub.setBounds(80,200,150,25);
        enter_Sub.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(enter_Sub);     
        
        JLabel enter_marks=new JLabel("Enter Marks");
        enter_marks.setBounds(300,200,150,25);
        enter_marks.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(enter_marks);
        
        
        
       String[] sub = {"",
    // B.Tech (Bachelor of Technology)
    "Electrical Engineering",
    "Power Systems",
    "Control Systems",
    "Electronics",
    "Mechanical Engineering",
    "Thermal Engineering",
    "Manufacturing Engineering",
    "Automotive Engineering",
    "Civil Engineering",
    "Structural Engineering",
    "Transportation Engineering",
    "Environmental Engineering",
    "Electronics and Communication Engineering",
    "Signal Processing",
    "VLSI Design",
    "Communication Systems",
    "Computer Science Engineering",
    "Software Engineering",
    "Data Science",
    "Artificial Intelligence",
    "Information Technology",
    
    // BA (Bachelor of Arts)
    "Sociology",
    "Social Research",
    "Criminology",
    "Gender Studies",
    "Anthropology",
    "Geography",
    "Philosophy",
    "Literature",
    "English Literature",
    "Comparative Literature",
    "Fine Arts",
    "Painting",
    "Sculpture",
    "Music",
    "Music Theory",
    "Music Composition",
    "Theatre and Performing Arts",
    "Acting",
    "Playwriting",
    
    // BSc (Bachelor of Science)
    "Zoology",
    "Ecology",
    "Genetics",
    "Botany",
    "Plant Pathology",
    "Horticulture",
    "Microbiology",
    "Astronomy",
    "Chemistry",
    "Organic Chemistry",
    "Inorganic Chemistry",
    "Physical Chemistry",
    "Geophysics",
    "Biotechnology",
    "Genetic Engineering",
    "Bioprocess Technology",
    "Statistics",
    
    // BCom (Bachelor of Commerce)
    "Business Law",
    "Cost Accounting",
    "Business Ethics",
    "International Business",
    "Auditing",
    "Entrepreneurship",
    
    // MBBS (Bachelor of Medicine, Bachelor of Surgery)
    "Microbiology",
    "Clinical Microbiology",
    "Medical Virology",
    "Pathology",
    "Clinical Pathology",
    "Anatomic Pathology",
    "Radiology",
    "Diagnostic Radiology",
    "Interventional Radiology",
    "Dermatology",
    "Pediatric Dermatology",
    "Dermatopathology",
    "Ophthalmology",
    "Retina and Vitreous Surgery",
    "Cornea and External Diseases",
    "Anesthesiology",
    "Pain Management",
    "Cardiothoracic Anesthesiology",
    "Orthopedics",
    "Pediatric Orthopedics",
    "Spine Surgery",
    
    // BBA (Bachelor of Business Administration)
    "Business Ethics",
    "Strategic Management",
    "Business Communication",
    "Supply Chain Management",
    "E-commerce",
    "Organizational Leadership",
    
    // MA (Master of Arts)
    "Linguistics",
    "Applied Linguistics",
    "Sociolinguistics",
    "Political Science",
    "International Relations",
    "Psychology",
    "Clinical Psychology",
    "Industrial-Organizational Psychology",
    "Sociology",
    "Medical Sociology",
    "Environmental Sociology",
    "Public Administration",
    
    // MSc (Master of Science)
    "Environmental Science",
    "Environmental Policy",
    "Environmental Management",
    "Computer Science",
    "Machine Learning",
    "Cybersecurity",
    "Cloud Computing",
    "Data Science",
    "Big Data Analytics",
    "Data Visualization",
    "Artificial Intelligence",
    "Natural Language Processing",
    "Computer Vision",
    "Biomedical Science",
    
    // MCom (Master of Commerce)
    "Taxation Laws",
    "Financial Accounting",
    "Management Accounting",
    "Auditing and Assurance",
    "Marketing Management",
    
    // BCA (Bachelor of Computer Applications)
    "Data Structures",
    "Algorithms",
    "Data Analysis",
    "Operating Systems",
    "Linux Administration",
    "Windows Server Management",
    "Computer Networks",
    "Network Security",
    "Wireless Networking",
    "Cybersecurity",
    "Ethical Hacking",
    "Network Penetration Testing",
    "Software Testing",
    "Automated Testing",
    "Manual Testing",
    "Mobile App Development",
    "Astrophysics",
    "Quantum Mechanics",
    "Material Science",
    "Robotics",
    "Nanotechnology",
    "Digital Signal Processing",
    "Control Engineering",
    "Agricultural Engineering",
    "Environmental Engineering",
    "Renewable Energy",
    "Aerospace Engineering",
    "Biomedical Engineering",
    "Chemical Engineering",
    "Industrial Engineering",
    "Petroleum Engineering",
    "Telecommunication Engineering",
    "Data Analytics",
    "Machine Learning",
    "Natural Language Processing",
    "Computer Graphics",
    "Image Processing",
    "Software Development",
    "Computer Vision",
    "Cryptocurrency",
    "Blockchain Technology",
    "Virtual Reality",
    "Augmented Reality",
    "Quantum Computing",
    "Big Data Analytics",
    "IoT (Internet of Things)",
    "Artificial Neural Networks",
    "Deep Learning",
    "Ethical Hacking",
    "Cybersecurity",
    "Bioinformatics",
    "Environmental Science",
    "Climate Change",
    "Marine Biology",
    "Ecology",
    "Geology",
    "Meteorology",
    "Space Exploration",
    "Astronomy",
    "Astrobiology",
    "Particle Physics",
    "Condensed Matter Physics",
    "Geophysics",
    "Cosmology",
    "Mathematics",
    "Pure Mathematics",
    "Applied Mathematics",
    "Statistics",
    "Actuarial Science",
    "Financial Mathematics",
    "Philosophy",
    "Political Science",
    "International Relations",
    "Psychology",
    "Counseling Psychology",
    "Developmental Psychology",
    "Forensic Psychology",
    "Clinical Psychology",
    "Sociology",
    "Criminology",
    "Anthropology",
    "Archaeology",
    "Cultural Studies",
    "Religious Studies",
    "History",
    "Art History",
    "Economics",
    "Microeconomics",
    "Macroeconomics",
    "Environmental Economics",
    "Business Management",
    "Marketing Management",
    "Human Resources",
    "Supply Chain Management",
    "Organizational Behavior",
    "Operations Research",
    "Business Analytics",
    "Finance",
    "Corporate Finance",
    "Investment Banking",
    "Financial Risk Management",
    "Accounting",
    "Financial Accounting",
    "Managerial Accounting",
    "Cost Accounting",
    "Auditing",
    "Taxation",
    "Digital Marketing",
    "Content Marketing",
    "Social Media Marketing",
    "Search Engine Optimization (SEO)",
    "Human Nutrition",
    "Dietetics",
    "Food Science",
    "Culinary Arts",
    "Fashion Design",
    "Interior Design",
    "Graphic Design",
    "Industrial Design",
    "Landscape Architecture",
    "Urban Planning",
    "Civil Law",
    "Criminal Law",
    "Corporate Law",
    "Environmental Law",
    "Human Rights Law",
    "International Law",
    "Medical Law",
    "Space Law",
    "Philology",
    "Linguistics",
    "Applied Linguistics",
    "Translation and Interpretation",
    "TESOL (Teaching English to Speakers of Other Languages)",
    "Sociolinguistics",
    "Cognitive Psychology",
    "Forensic Science",
    "Crime Scene Investigation",
    "Forensic Toxicology",
    "Forensic Anthropology",
    "Forensic Entomology",
    "Artificial Intelligence Ethics",
    "Quantum Mechanics",
    "Quantum Computing",
    "Quantum Cryptography",
    "Quantum Machine Learning",
    "Quantum Chemistry",
    "Biochemistry",
    "Molecular Biology",
    "Genetics",
    "Neuroscience",
    "Cell Biology",
    "Bioinformatics",
    "Genetic Engineering",
    "Bioprocess Technology",
    "Nanochemistry",
    "Nanomaterials",
    "Nanoelectronics",
    "Nanomedicine",
    "Environmental Chemistry",
    "Analytical Chemistry",
    "Physical Chemistry",
    "Inorganic Chemistry",
    "Organic Chemistry",
    "Medicinal Chemistry",
    "Astronomy",
    "Astrophysics",
    "Cosmology",
    "Planetary Science",
    "Astrobiology",
    "Particle Physics",
    "Nuclear Physics",
    "Quantum Field Theory",
    "String Theory",
    "Condensed Matter Physics",
    "Optics",
    "Geophysics",
    "Seismology",
    "Oceanography",
    "Atmospheric Science",
    "Marine Biology",
    "Zoology",
    "Botany",
    "Entomology",
    "Herpetology",
    "Ornithology",
    "Cell Biology",
    "Microbiology",
    "Immunology",
    "Virology",
    "Pharmacology",
    "Toxicology",
    "Pathology",
    "Clinical Pathology",
    "Anatomic Pathology",
    "Radiology",
    "Diagnostic Radiology",
    "Interventional Radiology",
    "Nuclear Medicine",
    "Dermatology",
    "Pediatric Dermatology",
    "Dermatopathology",
    "Ophthalmology",
    "Retina and Vitreous Surgery",
    "Cornea and External Diseases",
    "Endocrinology",
    "Nephrology",
    "Gastroenterology",
    "Cardiology",
    "Hematology",
    "Obstetrics and Gynecology",
    "Pediatrics",
    "Neonatology",
    "Child Psychiatry",
    "Surgery",
    "General Surgery",
    "Orthopedic Surgery",
    "Neurosurgery",
    "Cardiothoracic Surgery",
    "Urology",
    "Anesthesiology",
    "Pain Management",
    "Pediatric Anesthesiology",
    "Orthopedics",
    "Pediatric Orthopedics",
    "Spine Surgery",
    "Cardiac Surgery",
    "Plastic Surgery",
    "Vascular Surgery",
    "Critical Care Medicine",
    "Geriatric Medicine",
    "Neurology",
    "Neurology - Pediatric",
    "Neurology - Epilepsy",
    "Neurology - Headache Medicine",
    "Neurology - Neuromuscular Medicine",
    "Emergency Medicine",
    "Sports Medicine",
    "Rheumatology",
    "Physical Medicine and Rehabilitation",
    "Infectious Disease Medicine",
    "Nuclear Cardiology",
    "Radiation Oncology",
    "Vascular and Interventional Radiology",
    "Endovascular Surgical Neuroradiology",
    "Thoracic Surgery",
    "Colon and Rectal Surgery",
    "Hand Surgery",
    "Oral and Maxillofacial Surgery",
    "Pediatric Surgery",
    "Surgical Oncology",
    "Urologic Oncology",
    "Thoracic Surgery - Integrated",
    "Child and Adolescent Psychiatry",
    "Addiction Psychiatry",
    "Forensic Psychiatry",
    "Geriatric Psychiatry",
    "Psychosomatic Medicine",
    "Clinical Neurophysiology",
    "Hospital Medicine",
    "Sleep Medicine",
    "Spinal Cord Injury Medicine",
    "Hospice and Palliative Medicine",
    "Female Pelvic Medicine and Reconstructive Surgery",
    "Medical Toxicology",
    "Neurodevelopmental Disabilities",
    "Pediatric Cardiology",
    "Pediatric Critical Care Medicine",
    "Pediatric Emergency Medicine",
    "Pediatric Endocrinology",
    "Pediatric Gastroenterology",
    "Pediatric Hematology-Oncology",
    "Pediatric Infectious Diseases",
    "Pediatric Nephrology",
    "Pediatric Pulmonology",
    "Pediatric Rheumatology",
    "Pediatric Transplant Hepatology",
    "Pulmonary Disease",
    "Cardiovascular Disease",
    "Child Neurology",
    "Endocrinology, Diabetes, and Metabolism",
    "Hematology - Pathology",
    "Hepatology",
    "Infectious Disease",
    "Internal Medicine",
    "Neurology - Child Neurology",
    "Nuclear Medicine - Diagnostic",
    "Nuclear Medicine - Therapeutic",
    "Obstetrics and Gynecology",
    "Ophthalmology",
    "Otolaryngology",
    "Pain Medicine",
    "Pediatric Radiology",
    "Psychiatry",
    "Radiation Oncology - Hospice and Palliative Medicine",
    "Radiation Oncology - Pediatric",
    "Radiation Oncology - Therapeutic",
    "Radiology - Vascular and Interventional",
    "Radiology - Pediatric",
    "Radiology - Neuroradiology",
    "Sleep Medicine",
    "Sports Medicine",
    "Surgery - Vascular Surgery",
    "Surgery - Pediatric",
    "Urology - Female Pelvic Medicine and Reconstructive Surgery",
    "Vascular and Interventional Radiology - Diagnostic",
    "Vascular and Interventional Radiology - Therapeutic",
    "Vascular Surgery - Integrated",
    "Vascular Surgery - Pediatric",
    "Child and Adolescent Psychiatry - Neurology",
    "Internal Medicine - Pediatrics",
    "Pediatrics - Medical Genetics",
    "Pediatrics - Medical Toxicology",
    "Pediatrics - Neonatal-Perinatal Medicine",
    "Pediatrics - Clinical Informatics",
    "Surgery - Hand Surgery",
    "Surgery - Medical Informatics",
    "Surgery - Oral and Maxillofacial",
    "Surgery - Pediatric Orthopedics",
    "Surgery - Pediatric Surgery",
    "Surgery - Surgical Critical Care",
    "Surgery - Vascular Surgery - Pediatric",
    "Surgery - Spinal Cord Injury",
    "Neurology - Neurodevelopmental Disabilities",
    "Psychiatry - Psychosomatic Medicine",
    "Surgery - Surgical Oncology",
    "Surgery - Surgical Oncology",
    "Pediatrics - Pediatric Gastroenterology",
    "Surgery - Pediatric Orthopedics",
    "Pediatrics - Pediatric Rheumatology",
    "Pediatrics - Pediatric Transplant Hepatology",
    "Radiology - Hospice and Palliative Medicine",
    "Radiology - Pediatric",
    "Radiology - Vascular and Interventional",
    "Radiology - Neuroradiology",
    "Vascular Surgery",
    "Radiation Oncology",
    "Pediatrics - Neonatal-Perinatal Medicine",
    "Pediatrics - Clinical Informatics",
    "Surgery - Hand Surgery",
    "Surgery - Medical Informatics",
    "Surgery - Oral and Maxillofacial",
    "Psychiatry - Psychosomatic Medicine",
    "Surgery - Surgical Critical Care",
    "Surgery - Surgical Oncology",
    "Child and Adolescent Psychiatry - Neurology",
    "Internal Medicine - Pediatrics",
    "Pediatrics - Medical Genetics",
    "Pediatrics - Medical Toxicology",
    "Surgery - Vascular Surgery",
    "Pediatrics - Clinical Informatics",
    "Surgery - Hand Surgery",
    "Surgery - Medical Informatics",
    "Surgery - Oral and Maxillofacial",
    "Psychiatry - Psychosomatic Medicine",
    "Surgery - Surgical Critical Care",
    "Surgery - Surgical Oncology",
    "Aerospace Engineering",
    "Agricultural Engineering",
    "Animation",
    "Architecture",
    "Artificial Neural Networks",
    "Bioinformatics",
    "Biomedical Science",
    "Business Analytics",
    "Chemical Engineering",
    "Civil Law",
    "Cognitive Psychology",
    "Computer Graphics",
    "Construction Management",
    "Corporate Finance",
    "Cryptocurrency",
    "Cybersecurity",
    "Data Analysis",
    "Digital Marketing",
    "Electrical Engineering",
    "Environmental Law",
    "Environmental Policy",
    "Financial Risk Management",
    "Forensic Science",
    "Game Design",
    "Graphic Design",
    "Human Nutrition",
    "Human Rights Law",
    "Information Technology",
    "International Business",
    "Investment Banking",
    "Landscape Architecture",
    "Machine Learning",
    "Marketing Management",
    "Materials Science",
    "Mechanical Engineering",
    "Nanotechnology",
    "Neuroscience",
    "Nuclear Physics",
    "Oceanography",
    "Operations Research",
    "Organic Chemistry",
    "Philology",
    "Planetary Science",
    "Pure Mathematics",
    "Quantum Cryptography",
    "Quantum Machine Learning",
    "Renewable Energy",
    "Search Engine Optimization (SEO)",
    "Social Media Marketing",
    "Space Exploration",
    "Accounting",
    "Actuarial Science",
    "Advertising",
    "Aerospace Engineering",
    "Agricultural Engineering",
    "Agriculture",
    "Anatomy",
    "Animal Science",
    "Anthropology",
    "Applied Linguistics",
    "Aquaculture",
    "Architecture",
    "Art History",
    "Astronomy",
    "Astrobiology",
    "Biochemistry",
    "Bioinformatics",
    "Biological Sciences",
    "Biomedical Engineering",
    "Biotechnology",
    "Botany",
    "Business Administration",
    "Business Analytics",
    "Business Ethics",
    "Ceramic Engineering",
    "Chemical Engineering",
    "Chemistry",
    "Child Psychology",
    "Civil Engineering",
    "Cognitive Psychology",
    "Communication Studies",
    "Computer Engineering",
    "Computer Science",
    "Construction Management",
    "Counseling Psychology",
    "Criminology",
    "Culinary Arts",
    "Cybersecurity",
    "Dance",
    "Data Science",
    "Dentistry",
    "Digital Marketing",
    "Early Childhood Education",
    "Economics",
    "Electrical Engineering",
    "Electronics",
    "Elementary Education",
    "Engineering",
    "English Literature",
    "Environmental Engineering",
    "Environmental Science",
    "Epidemiology",
    "Fashion Design",
    "Film Studies",
    "Finance",
    "Food Science",
    "Forensic Science",
    "Game Design",
    "Genetics",
    "Geography",
    "Geology",
    "Graphic Design",
    "Health Administration",
    "History",
    "Hospitality Management",
    "Human Resources",
    "Industrial Design",
    "Information Systems",
    "Information Technology",
    "Interior Design",
    "International Relations",
    "Journalism",
    "Landscape Architecture",
    "Law",
    "Linguistics",
    "Management",
    "Marketing Management",
    "Materials Science",
    "Mathematics",
    "Mechanical Engineering",
    "Media Studies",
    "Medical Laboratory Science",
    "Medicine",
    "Meteorology",
    "Microbiology",
    "Music",
    "Neuroscience",
    "Nursing",
    "Nutrition",
    "Occupational Therapy",
    "Oceanography",
    "Pharmacology",
    "Philosophy",
    "Physics",
    "Political Science",
    "Psychiatry",
    "Psychology",
    "Public Administration",
    "Radiology",
    "Renewable Energy",
    "Sociology",
    "Software Engineering",
    "Statistics",
    "Supply Chain Management",
    "Theatre Arts",
    "Urban Planning",
    "Veterinary Medicine",
    "Video Game Design",
    "Web Development",
    "Wildlife Biology",
    "Zoology",
    // And here are more subjects...
    "Astrophysics",
    "Automotive Engineering",
    "Aviation Management",
    "Behavioral Science",
    "Bioinformatics",
    "Biological Engineering",
    "Biomedical Science",
    "Chemical Physics",
    "Child Development",
    "Clinical Psychology",
    "Communication Sciences",
    "Computer Graphics",
    "Conflict Resolution",
    "Criminal Justice",
    "Data Analytics",
    "Data Mining",
    "Dental Hygiene",
    "Design and Technology",
    "Digital Media",
    "Ecology",
    "Education",
    "Educational Leadership",
    "Electrical and Electronics Engineering",
    "Emergency Management",
    "Energy Management",
    "Entrepreneurship",
    "Environmental Design",
    "Environmental Health",
    "Epidemiology",
    "Event Management",
    "Film Production",
    "Financial Economics",
    "Fire Science",
    "Forestry",
    "Game Development",
    "Geographical Information Systems (GIS)",
    "Global Studies",
    "Health Informatics",
    "Health Science",
    "Human Resource Management",
    "Industrial Engineering",
    "Industrial-Organizational Psychology",
    "Information Security",
    "Information Systems Management",
    "Instructional Design",
    "International Business",
    "Kinesiology",
    "Landscape Design",
    "Legal Studies",
    "Library Science",
    "Management Information Systems",
    "Marketing Research",
    "Mechatronics Engineering",
    "Medical Imaging",
    "Meteorology",
    "Microelectronics",
    "Mobile App Development",
    "Molecular Biology",
    "Museum Studies",
    "Nanotechnology",
    "Natural Resource Management",
    "Network Administration",
    "Nuclear Engineering",
    "Nursing Education",
    "Operations Management",
    "Organizational Behavior",
    "Organizational Psychology",
    "Paralegal Studies",
    "Peace and Conflict Studies",
    "Petroleum Engineering",
    "Pharmaceutical Science",
    "Photography",
    "Physical Education",
    "Physiology",
    "Political Economy",
    "Population Health",
    "Project Management",
    "Public Health",
    "Public Relations",
    "Quantitative Finance",
    "Radiologic Technology",
    "Real Estate",
    "Renewable Energy Engineering",
    "Robotics Engineering",
    "Science Education",
    "Security Studies",
    "Social Work",
    "Software Testing",
    "Space Science",
    "Sports Management",
    "Structural Engineering",
    "Supply Chain and Logistics",
    "Sustainable Agriculture",
    "Telecommunication Engineering",
    "Theater Production",
    "Tourism Management",
    "Transportation Engineering",
    "User Experience Design",
    "Veterinary Nursing",
    "Video Game Programming",
    "Visual Arts",
    "Web Design",
    "Wildlife Conservation",
    "Wine Making",
    "Women's Studies",
    
               
};


         
         
        s1=new JComboBox<>(sub);
        s1.setBounds(50,250,200,25);
        s1.setFont(new Font("Tahoma",Font.PLAIN,15));
        s1.setSelectedIndex(0);  
        s1.setBackground(Color.WHITE);
        add(s1);
        
      
        
        s2=new JComboBox<>(sub);
        s2.setBounds(50,280,200,25);
        s2.setFont(new Font("Tahoma",Font.PLAIN,15));
        s2.setSelectedIndex(0);  
        s2.setBackground(Color.WHITE);
        add(s2);
        
       
        s3=new JComboBox<>(sub);
        s3.setBounds(50,310,200,25);
        s3.setFont(new Font("Tahoma",Font.PLAIN,15));
        s3.setSelectedIndex(0);  
        s3.setBackground(Color.WHITE);
        add(s3);
        
        
        s4=new JComboBox<>(sub);
        s4.setBounds(50,340,200,25);
        s4.setFont(new Font("Tahoma",Font.PLAIN,15));
        s4.setSelectedIndex(0);  
        s4.setBackground(Color.WHITE);
        add(s4);
      
       
        
        s5=new JComboBox<>(sub);
        s5.setBounds(50,370,200,25);
        s5.setFont(new Font("Tahoma",Font.PLAIN,15));
        s5.setSelectedIndex(0);  
        s5.setBackground(Color.WHITE);
        add(s5);
        
        
         JLabel mark1=new JLabel("100/");
            mark1.setBounds(300,250 ,50 ,25 );
            mark1.setFont(new Font("tahoma",Font.PLAIN,18));
            add(mark1);
            
            JLabel mark2=new JLabel("100/");
            mark2.setBounds(300,280 ,50 ,25 );
            mark2.setFont(new Font("tahoma",Font.PLAIN,18));
            add(mark2);
            
            JLabel mark3=new JLabel("100/");
            mark3.setBounds(300,310 ,50 ,25 );
            mark3.setFont(new Font("tahoma",Font.PLAIN,18));
            add(mark3);
            
            JLabel mark4=new JLabel("100/");
            mark4.setBounds(300,340 ,50 ,25 );
            mark4.setFont(new Font("tahoma",Font.PLAIN,18));
            add(mark4);
            
            JLabel mark5=new JLabel("100/");
            mark5.setBounds(300,370 ,50 ,25 );
            mark5.setFont(new Font("tahoma",Font.PLAIN,18));
             add(mark5);
        
        
        m1=new JTextField();
        m1.setBounds(340,250,60,25);
        m1.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(m1);
        
        m2=new JTextField();
        m2.setBounds(340,280,60,25);
        m2.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(m2);
        
        m3=new JTextField();
        m3.setBounds(340,310,60,25);
        m3.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(m3);
        
        m4=new JTextField();
        m4.setBounds(340,340,60,25);
        m4.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(m4);
        
        m5=new JTextField();
        m5.setBounds(340,370,60,25);
        m5.setFont(new Font("Tahoma",Font.PLAIN,15));
        add(m5);
        
        submit=new JButton("Submit");
        submit.setBounds(100, 420, 100, 25);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(250, 420, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
        
        setLocation(300,150);
        setSize(1000,520);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String roll_no=scroll.getSelectedItem();
            String semester=(String)sem.getSelectedItem();
            
            String sub1=s1.getSelectedItem().toString();
            String sub2=s2.getSelectedItem().toString();
            String sub3=s3.getSelectedItem().toString();
            String sub4=s4.getSelectedItem().toString();
            String sub5=s5.getSelectedItem().toString();
            
            String mar1=m1.getText();
            String mar2=m2.getText();
            String mar3=m3.getText();
            String mar4=m4.getText();
            String mar5=m5.getText();
            
            int mark1 = Integer.parseInt(mar1);
            int mark2 = Integer.parseInt(mar2);
            int mark3 = Integer.parseInt(mar3);
            int mark4 = Integer.parseInt(mar4);
            int mark5 = Integer.parseInt(mar5);
            
            int total= mark1 + mark2 + mark3 + mark4 + mark5;
            String totalmarks = String.valueOf(total);
            try{
                conn c=new conn();
                String query1="INSERT INTO subject VALUES ('"+roll_no+"','"+semester+"','"+sub1+"','"+sub2+"','"+sub3+"','"+sub4+"','"+sub5+"')";
                String query2="INSERT INTO marks VALUES ('"+roll_no+"','"+semester+"','"+mar1+"','"+mar2+"','"+mar3+"','"+mar4+"','"+mar5+"','"+totalmarks+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                JOptionPane.showMessageDialog(null, "Result Updated successfully");
                setVisible(false);
            }catch(Exception e){
              e.printStackTrace();
            }
        }else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    
    
    public static void main(String[]args){
        new Enter_marks();
    }
}
