package org.tasktracker.tasks.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Meeting extends Task {

    private LocalDate meetingStartDate;
    private LocalDate meetingEndDate;
    private LocalTime meetingStartTime;
    private LocalTime meetingEndTime;

    public LocalDate getMeetingStartDate() {
        return meetingStartDate;
    }

    public void setMeetingStartDate(LocalDate meetingStartDate) {
        this.meetingStartDate = meetingStartDate;
    }

    public LocalDate getMeetingEndDate() {
        return meetingEndDate;
    }

    public void setMeetingEndDate(LocalDate meetingEndDate) {
        this.meetingEndDate = meetingEndDate;
    }

    public LocalTime getMeetingStartTime() {
        return meetingStartTime;
    }

    public void setMeetingStartTime(LocalTime meetingStartTime) {
        this.meetingStartTime = meetingStartTime;
    }

    public LocalTime getMeetingEndTime() {
        return meetingEndTime;
    }

    public void setMeetingEndTime(LocalTime meetingEndTime) {
        this.meetingEndTime = meetingEndTime;
    }
}
