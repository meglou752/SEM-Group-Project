# USE CASE: 4 Produce a Report on the Salary of Employees of a Given Role

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *User* I want *to produce a report on the 'N' populated countries in the world* so that *I can support population reporting for the organisation.*

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

A request for data on population of the 'N' populated countries in the world.

## MAIN SUCCESS SCENARIO


1. User inputs the value of N
2. System retrieves data for all countries in database and selects the top N based on population
3. User uses data for intended report

## EXTENSIONS

3. **report does not exist**:
    1. User notes that report does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
