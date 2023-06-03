;;; Sierra Script 1.0 - (do not remove this comment)
(script# 807)
(include sci.sh)
(use Main)
(use Obj)


(class HandsOffScript of Script
	(properties
		client 0
		state $ffff
		start 0
		timer 0
		cycles 0
		seconds 0
		lastSeconds 0
		ticks 0
		lastTicks 0
		register 0
		script 0
		caller 0
		next 0
		oldIllBits 0
		saveIgnrAct 0
	)
	
	(method (init)
		(proc0_1)
		(= oldIllBits (gEgo illegalBits?))
		(= saveIgnrAct (& (gEgo signal?) $4000))
		(gEgo illegalBits: 0 ignoreActors: 1)
		(super init: &rest)
	)
	
	(method (dispose)
		(proc0_2)
		(gEgo illegalBits: oldIllBits ignoreActors: saveIgnrAct)
		(super dispose:)
	)
)
