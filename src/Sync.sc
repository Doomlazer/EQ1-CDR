;;; Sierra Script 1.0 - (do not remove this comment)
(script# 929)
(include sci.sh)
(use Main)
(use Timer)
(use Cycle)
(use Obj)


(class Sync of Obj
	(properties
		syncTime -1
		syncCue $ffff
		prevCue $ffff
		syncNum -1
	)
	
	(method (syncStart param1 param2 param3 param4 param5)
		(DoSync 0 self param1 param2 param3 param4 param5)
		(if (!= syncCue -1) (= prevCue syncCue) (= syncTime 0))
	)
	
	(method (syncCheck)
		(if
			(and
				(!= syncCue -1)
				(or (u<= syncTime global81) (<= syncTime (DoAudio 6)))
			)
			(if (== (& $fff0 syncCue) 0)
				(= prevCue (| (& prevCue $fff0) syncCue))
			else
				(= prevCue syncCue)
			)
			(DoSync 1 self)
		)
	)
	
	(method (syncStop)
		(= prevCue -1)
		(DoSync 2)
	)
)

(class ScriptSync of Obj
	(properties
		prevSignal -1
		playing 0
	)
	
	(method (init param1 param2 param3 param4 param5)
		(if gNewSync (self cue:))
		((= gNewSync (Sync new:))
			init:
			syncStart: param1 param2 param3 param4 param5
		)
		(if (!= (gNewSync prevCue?) -1)
			(= playing 1)
			(gRegions add: self)
		)
		(Timer
			setTicks: (DoAudio 1 param1 param2 param3 param4 param5) self
		)
	)
	
	(method (doit &tmp gNewSyncSyncTime)
		(if (!= (gNewSync prevCue?) -1)
			(repeat
				(if (== (gNewSync prevCue?) -1) (break))
				(= gNewSyncSyncTime (gNewSync syncTime?))
				(gNewSync syncCheck:)
				(if (== gNewSyncSyncTime (gNewSync syncTime?)) (break))
			)
			(= prevSignal (gNewSync prevCue?))
		)
	)
	
	(method (cue)
		(Animate (gCast elements?) 0)
		(= playing 0)
		(= prevSignal 32767)
		(gRegions delete: self)
		(if gNewSync
			(gNewSync syncStop: dispose:)
			(= gNewSync 0)
		)
	)
	
	(method (handleEvent)
	)
)

(class MouthSync of Cycle
	(properties
		client 0
		caller 0
		cycleDir 1
		cycleCnt 0
		completed 0
	)
	
	(method (init param1 param2 param3 param4 param5 param6 &tmp temp0)
		(super init: param1)
		(if (IsObject gNewSync) (gNewSync syncStop: dispose:))
		((= gNewSync (Sync new:))
			syncStart: param2 param3 param4 param5 param6
		)
	)
	
	(method (doit &tmp temp0 temp1 gNewSyncSyncTime_2 gNewSyncSyncTime temp4)
		(super doit:)
		(if (!= (gNewSync prevCue?) -1)
			(= gNewSyncSyncTime (gNewSync syncTime?))
			(= temp4 0)
			(repeat
				(= gNewSyncSyncTime_2 (gNewSync syncTime?))
				(gNewSync syncCheck:)
				(if (== gNewSyncSyncTime_2 (gNewSync syncTime?))
					(break)
				)
			)
			(if
				(and
					(!= gNewSyncSyncTime (gNewSync syncTime?))
					(!=
						(client cel?)
						(= temp1 (& $000f (gNewSync prevCue?)))
					)
				)
				(client cel: temp1)
			)
		else
			(= completed 1)
			(self cycleDone:)
		)
	)
	
	(method (dispose)
		(super dispose:)
		(if gNewSync (gNewSync dispose:) (= gNewSync 0))
	)
	
	(method (cue)
		(if gNewSync
			(gNewSync syncStop: dispose:)
			(= gNewSync 0)
			(if caller (caller cue:) (= caller 0))
		)
	)
)
