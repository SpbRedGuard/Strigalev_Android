package ru.Strigalev.mynotes;

public class Note {

    String NameNote;
    String BodyNote;
    String DateNote;

    public Note(String nameNote, String bodyNote, String dateNote) {
        NameNote = nameNote;
        BodyNote = bodyNote;
        DateNote = dateNote;
    }

    public String getNameNote() {
        return NameNote;
    }

    public void setNameNote(String nameNote) {
        NameNote = nameNote;
    }

    public String getBodyNote() {
        return BodyNote;
    }

    public void setBodyNote(String bodyNote) {
        BodyNote = bodyNote;
    }

    public String getDateNote() {
        return DateNote;
    }

    public void setDateNote(String dateNote) {
        DateNote = dateNote;
    }
}
