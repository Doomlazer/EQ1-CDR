;;; Sierra Script 1.0 - (do not remove this comment)
(script# 812)
(include sci.sh)
(use Main)
(use PRunAway)
(use PFollow)
(use Cycle)

(public
	Smopper 0
)

(class Smopper of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
		vInMotion 0
		vStopped 0
		vSlow 0
		vStart 0
		stopState 0
		useSlow 0
		cSpeed 0
		oldSpeed 0
		newCel 0
		tempMover 0
	)
	
	(method (init theClient theVStopped theVSlow theVStart theCSpeed theCaller)
		(= stopState 4)
		(= useSlow
			(= cycleCnt
				(= vSlow (= vStart (= vStopped (= caller 0))))
			)
		)
		(= cSpeed ((= client theClient) cycleSpeed?))
		(= oldSpeed ((= client theClient) cycleSpeed?))
		(if argc
			(= vInMotion ((= client theClient) view?))
			(if (>= argc 2)
				(= vStopped theVStopped)
				(if (>= argc 3)
					(= vSlow theVSlow)
					(if (>= argc 4)
						(if (== theVStart 0)
							(= useSlow 1)
							(= vStart vSlow)
						else
							(= vStart theVStart)
						)
						(if (>= argc 5)
							(if (!= theCSpeed -1) (= cSpeed theCSpeed))
							(if (>= argc 6) (= caller theCaller))
						)
					else
						(= useSlow 1)
						(= vStart vSlow)
					)
				)
			)
		)
		(super init: client)
	)
	
	(method (doit &tmp temp0 clientMover)
		(cond 
			((client isStopped:)
				(if (== (client view?) vInMotion)
					(cond 
						((and vSlow (!= (client view?) vSlow)) (= stopState 1))
						(
						(and (not vSlow) (!= (client view?) vStopped)) (= stopState 3))
						(else (= stopState 4))
					)
					(if
						(and
							(= clientMover (client mover?))
							(not (clientMover completed?))
							(not (clientMover isKindOf: PRunAway))
							(not (clientMover isKindOf: PFollow))
						)
						(client setMotion: 0)
					)
				)
			)
			((== (client view?) vStopped)
				(cond 
					(vStart (= stopState 5))
					((!= stopState 0) (= stopState 7))
				)
			)
			((and (== (client view?) vSlow) (not useSlow)) (= stopState 5))
		)
		(switch stopState
			(0
				(= cycleDir 1)
				(= newCel (self nextCel:))
				(if (> newCel (client lastCel:)) (= newCel 0))
				(client setCel: newCel)
			)
			(1
				(= cycleDir 1)
				(if (not vSlow)
					(client view: vStopped)
					(= stopState 3)
				else
					(= stopState 2)
					(if (== (client view?) vInMotion)
						(= newCel 0)
						(client setCel: 0)
					)
					(client cycleSpeed: cSpeed view: vSlow)
				)
			)
			(2
				(client cycleSpeed: cSpeed)
				(client setCel: newCel forceUpd:)
				(= newCel (self nextCel:))
				(if (> newCel (client lastCel:))
					(= newCel 0)
					(= stopState 3)
				)
			)
			(3
				(client cycleSpeed: cSpeed)
				(= stopState 4)
				(= cycleDir 1)
				(client view: vStopped cel: 0)
				(if caller (caller cue: 0))
			)
			(4
				(client cycleSpeed: cSpeed)
				(if (client lastCel:)
					(= newCel (self nextCel:))
					(if (> newCel (client lastCel:)) (= newCel 0))
					(client setCel: newCel)
				else
					0
				)
			)
			(5
				(if caller (caller cue: 1))
				(if (not vStart)
					(client view: vInMotion)
					(= stopState 7)
				else
					(= stopState 6)
					(if useSlow
						(if (== (client view?) vStopped)
							(client setCel: (client lastCel:))
							(= newCel (client lastCel:))
						)
						(client cycleSpeed: cSpeed view: vSlow)
						(= cycleDir -1)
					else
						(if (== (client view?) vStopped) (client setCel: 0))
						(client cycleSpeed: cSpeed view: vStart)
						(= cycleDir 1)
					)
				)
			)
			(6
				(client cycleSpeed: cSpeed)
				(if useSlow
					(if (not newCel)
						(= stopState 7)
					else
						(client setCel: newCel)
					)
					(= newCel (self nextCel:))
				else
					(= newCel (self nextCel:))
					(if (> newCel (client lastCel:))
						(= stopState 7)
					else
						(client setCel: newCel)
					)
				)
			)
			(7
				(= stopState 0)
				(= cycleDir 1)
				(client cycleSpeed: oldSpeed view: vInMotion cel: 0)
			)
		)
	)
	
	(method (dispose)
		(client cycleSpeed: oldSpeed)
		(if (!= (client view?) vInMotion)
			(client view: vInMotion)
		)
		(super dispose:)
	)
	
	(method (nextCel &tmp clientLastCel)
		(= clientLastCel (client lastCel:))
		(return
			(if
			(< (Abs (- gCycleCnt cycleCnt)) (client cycleSpeed?))
				(return (client cel?))
			else
				(= cycleCnt gCycleCnt)
				(return (+ (client cel?) cycleDir))
			)
		)
	)
)
