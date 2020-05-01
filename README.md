# Fluent builders

Exploring the different implementations for fluent builder pattern.

We have two main strategies:

## Simple fluent builder

The user can choose the fields and the order or field setting.
There is no limitations and no constraints, so the final construction may fail on missing fields.

The implementations are:
* Classic
* Functional
* Lombok

## Step fluent builder

The **user cannot choose fields nor order to set**. 
The builder offers the fields to set in a **fixed guided sequence**.
This is the most **strict and secure** way to create valid objects. 

The implementations are:
* Classic
* Functional