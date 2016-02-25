package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }


    @Override
    public Set<String> getAllUsers() {
        Set<String> allUsers = new HashSet<>();
        List<String> allStringFromFile = getAllStringFromFile(logDir);
        List<Log> logs = convertToLog(allStringFromFile);

        for (Log log : logs) {
            allUsers.add(log.getName());
        }

        return allUsers;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> allUsers = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                allUsers.add(log.getName());
            }


        }


        return allUsers.size();
    }

    public List<Log> getListLogs() {
        List<String> allStringFromFile = getAllStringFromFile(logDir);
        List<Log> logs = convertToLog(allStringFromFile);
        Collections.sort(logs, new Comparator<Log>() {
            @Override
            public int compare(Log o1, Log o2) {
                return o1.getDate().compareTo(o2.getDate());
            }
        });
        return logs;
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        List<Event> listEvent = new ArrayList<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getName().equals(user)) {
                    listEvent.add(log.getEvent());
                }
            }
        }

        return listEvent.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> listUserByIp = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getIp().equals(ip)) {
                    listUserByIp.add(log.getName());
                }
            }
        }

        return listUserByIp;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> listUserByLogin = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.LOGIN)) {
                    listUserByLogin.add(log.getName());
                }
            }
        }

        return listUserByLogin;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> listUserByLogin = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                    listUserByLogin.add(log.getName());
                }
            }
        }

        return listUserByLogin;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> listUserByWriteMessage = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.WRITE_MESSAGE)) {
                    listUserByWriteMessage.add(log.getName());
                }
            }
        }

        return listUserByWriteMessage;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> listUserBySolveTask = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.SOLVE_TASK)) {
                    listUserBySolveTask.add(log.getName());
                }
            }
        }

        return listUserBySolveTask;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> listUserBySolveTaskNum = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.SOLVE_TASK) && log.getNum() == task) {
                    listUserBySolveTaskNum.add(log.getName());
                }
            }
        }

        return listUserBySolveTaskNum;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> listUserByDoneTask = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.DONE_TASK)) {
                    listUserByDoneTask.add(log.getName());
                }
            }
        }

        return listUserByDoneTask;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {

        Set<String> listUserBySolveTaskNum = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {

                if (log.getEvent().equals(Event.DONE_TASK) && log.getNum() == task) {
                    listUserBySolveTaskNum.add(log.getName());
                }
            }
        }

        return listUserBySolveTaskNum;
    }


    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> rezultUniqueIp = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                rezultUniqueIp.add(log.getIp());
            }
        }


        return rezultUniqueIp.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> allUniqueIp = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }
        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                allUniqueIp.add(log.getIp());
            }
        }

        return allUniqueIp;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {

        Set<String> allUniqueIpUser = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }
        for (Log log : logs) {
            Date dateLog = log.getDate();
            String name = log.getName().trim().toLowerCase();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getName().equals(user)) {
                    allUniqueIpUser.add(log.getIp());
                }
            }
        }

        return allUniqueIpUser;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<String> allUniqueIpEvent = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }
        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(event)) {
                    allUniqueIpEvent.add(log.getIp());
                }
            }
        }

        return allUniqueIpEvent;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<String> allUniqueIpStatus = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }
        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getStatus().equals(status)) {
                    allUniqueIpStatus.add(log.getIp());
                }
            }
        }

        return allUniqueIpStatus;
    }


    private List<String> getAllStringFromFile(Path logDir) {
        List<String> rezultList = new ArrayList<>();
        File file = logDir.toFile();
        String absPath = file.getAbsolutePath();

        String[] list = file.list();

        for (String s : list) {
            if (s.endsWith(".log")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(absPath + File.separator + s))) {
                    String fileLine = "";
                    while (reader.ready()) {
                        rezultList.add(reader.readLine());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return rezultList;
    }

    private List<Log> convertToLog(List<String> list) {
        List<Log> logList = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        for (String s : list) {

            Log log;
            Date date = null;
            s = removeExtraSpace(s);
            String[] split = s.split(" ");
            StringBuilder builderName = new StringBuilder();
            StringBuilder builderDate = new StringBuilder();
            String ip = "";
            Event event = null;
            Status status = null;
            int numTask = -1;
            for (int i = 0; i < split.length; i++) {

                if (i == 0 && checkCorrectIp(split[i])) {
                    ip = split[i];
                }
                if (i > 0 && i < 4 && hasStringAllLetter(split[i])) {
                    builderName.append(split[i] + " ");
                }
                if (i > 1 && i < 6 && checkStartDate(split[i])) {
                    builderDate.append(split[i] + " ");
                }
                if (i > 1 && i < 6 && checkEndDate(split[i])) {
                    builderDate.append(split[i]);
                }
                if (i > 3 && checkEvent(split[i])) {
                    event = convertStringToEvent(split[i]);
                    if (event.equals(Event.DONE_TASK) || event.equals(Event.SOLVE_TASK)) {
                        numTask = Integer.parseInt(split[i + 1]);
                    }
                }
                if (checkStatus(split[i])) {
                    status = convertStringToStatus(split[i]);
                }
            }
            try {
                date = format.parse(builderDate.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }

            log = new Log(ip, builderName.toString().trim(), date, event, numTask, status);
            logList.add(log);
        }


        return logList;
    }

    private Status convertStringToStatus(String s) {
        switch (s) {
            case "OK":
                return Status.OK;
            case "FAILED":
                return Status.FAILED;
            case "ERROR":
                return Status.ERROR;

        }
        return null;

    }

    private boolean checkStatus(String s) {
        String status = "";
        try {
            status = Status.valueOf(s).name();
        } catch (Exception ignore) {
        }
        return s.equals(status);

    }

    private boolean checkEvent(String s) {
        String event = "";
        try {
            event = Event.valueOf(s).name();
        } catch (Exception ignore) {
        }
        return s.equals(event);
    }

    private Event convertStringToEvent(String s) {
        switch (s) {
            case "LOGIN":
                return Event.LOGIN;
            case "DOWNLOAD_PLUGIN":
                return Event.DOWNLOAD_PLUGIN;
            case "WRITE_MESSAGE":
                return Event.WRITE_MESSAGE;
            case "SOLVE_TASK":
                return Event.SOLVE_TASK;
            case "DONE_TASK":
                return Event.DONE_TASK;
        }
        return null;
    }

    private boolean checkEndDate(String s) {

        Pattern p = Pattern.compile("([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    private boolean checkStartDate(String s) {
        Pattern p = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((19|20)\\d\\d)");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    private boolean checkCorrectIp(String s) {
        Pattern p = Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$");
        Matcher m = p.matcher(s);
        return m.matches();
    }

    private String removeExtraSpace(String s) {
        return Pattern.compile("[\\s]+").matcher(s).replaceAll(" ").trim();
    }

    private boolean hasStringAllLetter(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                count++;
            }
        }
        return count == s.length();
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> listDateByEvent = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getName().equals(user) && log.getEvent().equals(event)) {
                    listDateByEvent.add(log.getDate());
                }
            }
        }

        return listDateByEvent;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> listDateByEvent = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getStatus().equals(Status.FAILED)) {
                    listDateByEvent.add(log.getDate());
                }
            }
        }

        return listDateByEvent;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> listDateByStatus = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getStatus().equals(Status.ERROR)) {
                    listDateByStatus.add(log.getDate());
                }
            }
        }

        return listDateByStatus;

    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date firstLogin = null;
        List<Log> logs = getListLogs();
        int count = 0;
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (user.equals(log.getName()) && log.getEvent().equals(Event.LOGIN) && count == 0) {
                    firstLogin = log.getDate();
                    count++;
                }
            }
        }

        return firstLogin;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date firstSolved = null;
        List<Log> logs = getListLogs();
        int count = 0;
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (user.equals(log.getName()) && log.getEvent().equals(Event.SOLVE_TASK) && log.getNum() == task && count == 0) {
                    firstSolved = log.getDate();
                    count++;
                }
            }
        }

        return firstSolved;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date firstDoneTask = null;
        List<Log> logs = getListLogs();
        int count = 0;
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (user.equals(log.getName()) && log.getEvent().equals(Event.DONE_TASK) && log.getNum() == task && count == 0) {
                    firstDoneTask = log.getDate();
                    count++;
                }
            }
        }

        return firstDoneTask;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> listDateByStatus = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (user.equals(log.getName()) && log.getEvent().equals(Event.WRITE_MESSAGE)) {
                    listDateByStatus.add(log.getDate());
                }
            }
        }

        return listDateByStatus;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> listDateByPlagin = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (user.equals(log.getName()) && log.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                    listDateByPlagin.add(log.getDate());
                }
            }
        }

        return listDateByPlagin;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        Set<Event> listEventByDate = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent() != null) {
                    listEventByDate.add(log.getEvent());
                }
            }
        }

        return listEventByDate.size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> listEventByDate = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent() != null) {
                    listEventByDate.add(log.getEvent());
                }
            }
        }

        return listEventByDate;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> listEventByDate = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getIp().equals(ip)) {
                    listEventByDate.add(log.getEvent());
                }
            }
        }

        return listEventByDate;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> listEventByUser = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getName().equals(user)) {
                    listEventByUser.add(log.getEvent());
                }
            }
        }

        return listEventByUser;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> listEventByFiled = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getStatus().equals(Status.FAILED)) {
                    listEventByFiled.add(log.getEvent());
                }
            }
        }

        return listEventByFiled;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> listStatusByError = new HashSet<>();
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getStatus().equals(Status.ERROR)) {
                    listStatusByError.add(log.getEvent());
                }
            }
        }

        return listStatusByError;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.SOLVE_TASK) && log.getNum() == task) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {

        int count = 0;
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.DONE_TASK) && log.getNum() == task) {
                    count++;
                }
            }
        }

        return count;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {

        Map<Integer, Integer> mapSolvedTask = new HashMap<>();
        int count = 0;
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.SOLVE_TASK)) {

                    if (!mapSolvedTask.containsKey(log.getNum())) {
                        mapSolvedTask.put(log.getNum(), 1);
                    } else {
                        mapSolvedTask.put(log.getNum(), mapSolvedTask.get(log.getNum()) + 1);
                    }
                }
            }
        }

        return mapSolvedTask;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> mapDoneTask = new HashMap<>();
        int count = 0;
        List<Log> logs = getListLogs();
        if (after == null) {
            after = logs.get(0).getDate();
        }
        if (before == null) {
            before = logs.get(logs.size() - 1).getDate();
        }

        for (Log log : logs) {

            Date dateLog = log.getDate();
            if (dateLog.before(before) && dateLog.after(after) || dateLog.equals(before) || dateLog.equals(after)) {
                if (log.getEvent().equals(Event.DONE_TASK)) {

                    if (!mapDoneTask.containsKey(log.getNum())) {
                        mapDoneTask.put(log.getNum(), 1);
                    } else {
                        mapDoneTask.put(log.getNum(), mapDoneTask.get(log.getNum()) + 1);
                    }
                }
            }
        }

        return mapDoneTask;
    }


    @Override
    public Set<Object> execute(String query) {
        Set<Object> rezultSet = new HashSet<>();
        List<Log> logs = getListLogs();
        String[] split = query.split("=");

        String[] split1 = split[0].trim().split(" ");
        String strGet = split1[1].trim();
        String strFor = split1[3].trim();


        String dataQuery = split[1].trim().replaceAll("\"", "");

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        switch (strGet) {
            case "ip":
                if (strFor.equals("user")) {
                    for (Log log : logs) {
                        if (log.getName().equals(dataQuery)) {
                            rezultSet.add(log.getIp());
                        }

                    }
                }
                if (strFor.equals("date")) {
                    Date parse = null;
                    try {
                        parse = format.parse(dataQuery);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    for (Log log : logs) {
                        if (log.getDate().equals(parse)) {
                            rezultSet.add(log.getIp());
                        }
                    }
                }
                if (strFor.equals("event")) {
                    for (Log log : logs) {

                        if (log.getEvent().equals(convertStringToEvent(dataQuery))) {
                            rezultSet.add(log.getIp());
                        }
                    }
                }
                if (strFor.equals("status")) {
                    for (Log log : logs) {

                        if (log.getStatus().equals(convertStringToStatus(dataQuery))) {
                            rezultSet.add(log.getIp());
                        }
                    }
                }

                break;
            case "user":
                if (strFor.equals("ip")) {
                    for (Log log : logs) {

                        if (log.getIp().equals(dataQuery)) {
                            rezultSet.add(log.getName());
                        }
                    }
                }
                if (strFor.equals("date")) {
                    Date parse = null;
                    try {
                        parse = format.parse(dataQuery);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    for (Log log : logs) {

                        if (log.getDate().equals(parse)) {
                            rezultSet.add(log.getName());
                        }
                    }
                }
                if (strFor.equals("event")) {
                    for (Log log : logs) {

                        if (log.getEvent().equals(convertStringToEvent(dataQuery))) {
                            rezultSet.add(log.getName());
                        }
                    }
                }
                if (strFor.equals("status")) {
                    for (Log log : logs) {

                        if (log.getStatus().equals(convertStringToStatus(dataQuery))) {
                            rezultSet.add(log.getName());
                        }
                    }
                }

                break;
            case "date":
                if (strFor.equals("ip")) {
                    for (Log log : logs) {

                        if (log.getIp().equals(dataQuery)) {
                            rezultSet.add(log.getDate());
                        }
                    }
                }
                if (strFor.equals("user")) {
                    for (Log log : logs) {

                        if (log.getName().equals(dataQuery)) {
                            rezultSet.add(log.getDate());
                        }
                    }
                }
                if (strFor.equals("event")) {
                    for (Log log : logs) {

                        if (log.getEvent().equals(convertStringToEvent(dataQuery))) {
                            rezultSet.add(log.getDate());
                        }
                    }
                }
                if (strFor.equals("status")) {
                    for (Log log : logs) {

                        if (log.getStatus().equals(convertStringToStatus(dataQuery))) {
                            rezultSet.add(log.getDate());
                        }
                    }
                }


                break;
            case "event":
                if (strFor.equals("ip")) {
                    for (Log log : logs) {

                        if (log.getIp().equals(dataQuery)) {
                            rezultSet.add(log.getEvent());
                        }
                    }
                }
                if (strFor.equals("user")) {
                    for (Log log : logs) {

                        if (log.getName().equals(dataQuery)) {
                            rezultSet.add(log.getEvent());
                        }
                    }
                }
                if (strFor.equals("date")) {
                    Date parse = null;
                    try {
                        parse = format.parse(dataQuery);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    for (Log log : logs) {

                        if (log.getDate().equals(parse)) {
                            rezultSet.add(log.getEvent());
                        }
                    }
                }
                if (strFor.equals("status")) {
                    for (Log log : logs) {

                        if (log.getStatus().equals(convertStringToStatus(dataQuery))) {
                            rezultSet.add(log.getEvent());
                        }
                    }
                }

                break;
            case "status":
                if (strFor.equals("ip")) {
                    for (Log log : logs) {

                        if (log.getIp().equals(dataQuery)) {
                            rezultSet.add(log.getStatus());
                        }
                    }
                }
                if (strFor.equals("user")) {
                    for (Log log : logs) {

                        if (log.getName().equals(dataQuery)) {
                            rezultSet.add(log.getStatus());
                        }
                    }
                }
                if (strFor.equals("date")) {
                    Date parse = null;
                    try {
                        parse = format.parse(dataQuery);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    for (Log log : logs) {

                        if (log.getDate().equals(parse)) {
                            rezultSet.add(log.getStatus());
                        }
                    }
                }
                if (strFor.equals("event")) {
                    for (Log log : logs) {

                        if (log.getEvent().equals(convertStringToEvent(dataQuery))) {
                            rezultSet.add(log.getStatus());
                        }
                    }
                }
                break;
        }
        return rezultSet;
    }


    private class Log {
        private String ip;
        private String name;
        private Date date;
        Event event;
        int num;
        Status status;


        public Log(String ip, String name, Date date, Event event, int num, Status status) {
            this.ip = ip;
            this.name = name;
            this.date = date;
            this.event = event;
            this.num = num;
            this.status = status;
        }

        public String getIp() {
            return ip;
        }


        public String getName() {
            return name;
        }


        public Date getDate() {
            return date;
        }


        public Event getEvent() {
            return event;
        }


        public int getNum() {
            return num;
        }


        public Status getStatus() {
            return status;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Log log = (Log) o;

            if (num != log.num) return false;
            if (!date.equals(log.date)) return false;
            if (event != log.event) return false;
            if (!ip.equals(log.ip)) return false;
            if (!name.equals(log.name)) return false;
            if (status != log.status) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = ip.hashCode();
            result = 31 * result + name.hashCode();
            result = 31 * result + date.hashCode();
            result = 31 * result + event.hashCode();
            result = 31 * result + num;
            result = 31 * result + status.hashCode();
            return result;
        }

        @Override
        public String toString() {

            if (num > 0) {
                return "Log{" +
                        "ip='" + ip + '\'' +
                        ", name='" + name + '\'' +
                        ", date=" + date +
                        ", event=" + event +
                        ", num=" + num +
                        ", status=" + status +
                        '}';
            } else {
                return "Log{" +
                        "ip='" + ip + '\'' +
                        ", name='" + name + '\'' +
                        ", date=" + date +
                        ", event=" + event +
                        ", status=" + status +
                        '}';

            }
        }
    }


}
