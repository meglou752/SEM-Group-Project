# USE CASE: 10 Produce a report on all the cities in a country with population in descending order

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *User* I want *to produce a report on all the cities in a specified country with population in descending order* so that *I can support population reporting for the organisation.*

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

A request for data on population of all cities in a country ordered in descending order.

## MAIN SUCCESS SCENARIO


1. User selects country
2. System retrieves data for all cities in the country and orders in descending based on population 
3. User uses data for intended report

## EXTENSIONS

3. **report does not exist**:
    1. User notes that report does not exist.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
