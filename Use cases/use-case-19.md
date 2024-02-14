# USE CASE: 19 Produce Report of All Capital Cities in a Region

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *user*, I want to *produce a report on all of the capital cities in a region organised by
largest population to smallest*.

### Scope

Company

### Level

Primary task.

### Preconditions

We know the role.  Database contains current population data per city and the region.

### Success End Condition

A report is produced for the user.

### Failed End Condition

No report is produced.

### Primary Actor

User

### Trigger

A request for population report for capital cities population in a region, organised by population
descending, is sent to the Organisation.

## MAIN SUCCESS SCENARIO

1. Population data for a specific region is requested.
2. User extracts current population data for each capital city in the region,
   organised by size descending.
3. User passes on the figure to the relevant department/employee.

## EXTENSIONS

None.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0