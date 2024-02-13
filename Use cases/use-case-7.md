# USE CASE: 4 Produce a Report on the Salary of Employees of a Given Role

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *User* I want *to produce a report on all the cities in the world with population in descending order* so that *I can support population reporting for the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the role.  Database contains current data on world population.

### Success End Condition

A report is available for user to use in order to further their work.

### Failed End Condition

No report is produced.

### Primary Actor

User.

### Trigger

A request for data on population of all cities in the world ordered in descending order.

## MAIN SUCCESS SCENARIO


1. User requests population of all cities in the world
2. System retrieves data for all cities in database in the world and orders in descending based on population 
4. User uses data for intended report

## EXTENSIONS

3. **report does not exist**:
    1. User notes that report does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
