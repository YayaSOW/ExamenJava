    package entities;

    import java.time.LocalDate;

    public class Etudiant {
        private int id;
        private String matricule;
        private String nom;
        private String prenom;
        private String email;
        private String tel;
        private LocalDate dateNaissance;
        private static int nbreEtudiant;
        public Etudiant(String nom, String prenom, String email, String tel,LocalDate dateNaissance) {
            this.id = ++nbreEtudiant;
            this.matricule = generateNumero(id, "MAT");
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.tel = tel;
            this.dateNaissance = dateNaissance;
        }
        public Etudiant() {
            this.id = ++nbreEtudiant;
            this.matricule = generateNumero(id, "MAT");
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getMatricule() {
            return matricule;
        }
        public void setMatricule(String matricule) {
            this.matricule = matricule;
        }
        public String getNom() {
            return nom;
        }
        public void setNom(String nom) {
            this.nom = nom;
        }
        public String getPrenom() {
            return prenom;
        }
        public void setPrenom(String prenom) {
            this.prenom = prenom;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public LocalDate getDateNaissance() {
            return dateNaissance;
        }
        public void setDateNaissance(LocalDate dateNaissance) {
            this.dateNaissance = dateNaissance;
        }

        public  String generateNumero(int nbre,String format){
            int size=String.valueOf(nbre).length();
            return format+"0".repeat((4-size)<0?0:4-size)+nbre;
        }
        @Override
        public String toString() {
            return "Etudiant [id=" + id + ", matricule=" + matricule + ", nom=" + nom + ", prenom=" + prenom + ", email="
                    + email + ", tel=" + tel + ", dateNaissance=" + dateNaissance + "]";
        }
    }
