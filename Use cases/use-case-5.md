# USE CASE: 5 Produce a report on the top 'N' populated countries in a continent

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *User* I want *to produce a report on the top 'N' populated countries in a specified continent* so that *I can support population reporting for the organisation.*

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

A request for data on population of 'N' populated countries in a specified continent.

## MAIN SUCCESS SCENARIO


1. User inputs the value of N 
2. User selects continent 
3. System retrieves data for all countries in database in the selected continent and selects the top N based on population 
4. User uses data for intended report

## EXTENSIONS

3. **report does not exist**:
    1. User notes that report does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0